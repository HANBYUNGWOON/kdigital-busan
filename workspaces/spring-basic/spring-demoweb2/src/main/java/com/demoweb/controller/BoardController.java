package com.demoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.service.BoardService;
import com.demoweb.vo.BoardVO;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@GetMapping(path = { "/list" })
	public String list(Model model) {
		
		// 데이터 조회
		List<BoardVO> boards = boardService.findAll();
		
		// View에서 사용할 수 있도록 Model 타입의 전달인자에 저장 -> Request 객체에 저장
		model.addAttribute("boards", boards);
		
		return "board/list";	// /WEB-INF/views/ + board/list + .jsp
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		
		return "board/write";
	}
	
	@PostMapping(path = { "/write" })
	public String write(BoardVO board) {
		
		// 데이터 읽기 ( 전달인자를 통해서 자동으로 읽어서 저장 )
		// 데이터베이스에 저장
		boardService.writeBoard(board);
		
		// 목록으로 이동
		return "redirect:list";
	}
	
	@GetMapping(path = { "/detail" })
	public String detail(int boardNo) {
		
		// 1. 요청 데이터 읽기 ( 전달인자로 대체 )
		System.out.println(boardNo);
		
		return "board/detail";
	}

}
