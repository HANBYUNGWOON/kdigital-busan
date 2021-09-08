package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.vo.BoardVO;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {
	
	@GetMapping(path = { "/list" })
	public String list() {
		
		return "board/list";	// /WEB-INF/views/ + board/list + .jsp
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		
		return "board/write";
	}
	
	@PostMapping(path = { "/write" })
	public String write(BoardVO board) {
		
		// 데이터 읽기 ( 전달인자를 통해서 자동으로 읽어서 저장 )
		System.out.println(board.toString());
		// 데이터베이스에 저장
		
		// 목록으로 이동
		return "redirect:list";
	}

}
