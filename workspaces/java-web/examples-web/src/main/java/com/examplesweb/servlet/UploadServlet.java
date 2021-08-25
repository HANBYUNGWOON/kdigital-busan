package com.examplesweb.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(urlPatterns = { "/file-upload" })
public class UploadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		if (!ServletFileUpload.isMultipartContent(req)) { // 현재 요청이 파일 첨부인지 확인 : multipart/form-data 여부
			resp.sendRedirect("g.file-upload-form.jsp");
			return;
		}
		
		try {			
			// 1. 요청 데이터 읽기 + 분해
			// 2. 1의 결과를 배열 또는 리스트로 반환
			//ServletContext application -> jsp에서 application 내장 객체와 같은 객체
			ServletContext application = req.getServletContext();		
	
			//경로 문자열을 저장할 변수
			//application.getRealPath('웹경로')
			//--> 가상경로(웹경로) -> 물리경로(컴퓨터경로)
			//--> http://..... -> C:/......
			String path = application.getRealPath("/upload-files");		//최종 파일 저장 경로
			String tempPath = application.getRealPath("/upload-temp");	//임시 파일 저장 경로
	
//			System.out.println(path);
//			System.out.println(tempPath);
	
			//분리된 요소를 처리할 때 사용할 처리기
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024 * 2);	//임시 파일을 만들지 결정하는 기준 설정
			factory.setRepository(new File(tempPath));	//임시 파일 저장 경로 지정
	
			//요청 정보를 읽을 파서(Parser) 생성 (요청을 읽고 요소별로 분리)
			ServletFileUpload uploader = new ServletFileUpload(factory);
			uploader.setFileSizeMax(1024 * 1024 * 10);//최대 파일 크기
	
			//요청 정보를 파싱하고 개별 객체의 목록을 반환
			List<FileItem> items = uploader.parseRequest(req);
	
			////////////////////////////////////////////////////////////////////////////////
			// 3. 2의 결과를 사용해서 데이터 처리
	
			//목록에 담긴 데이터 사용
			for (FileItem item : items) {	
				if (item.isFormField()) { //form-data인 경우 (File이 아닌 일반 데이터인 경우)
					System.out.println("DATA " + item.getFieldName() + " : " 
											   + item.getString("utf-8"));
				} else { //file인 경우
					String fileName = item.getName(); //파일 이름 가져오기
					if (fileName != null && fileName.length() > 0) { //내용이 있는 경우
						if (fileName.contains("\\")) { // iexplore 경우
							//C:\AAA\BBB\CCC.png -> CCC.png 
							fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
						}
						item.write(new File(path, fileName)); //파일 저장
						item.delete(); //임시 파일 삭제
					}
				}
			}
	
			resp.sendRedirect("g.file-list.jsp");
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		

		
		
	}

}
