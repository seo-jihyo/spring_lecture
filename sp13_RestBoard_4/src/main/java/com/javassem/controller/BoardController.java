package com.javassem.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.dao.BoardDAO;
import com.javassem.domain.BoardVO;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	BoardDAO boardDAO;
	
	@PostMapping("/insert")
	public void insert(@RequestBody BoardVO vo) {
		boardDAO.insertBoard(vo);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	@DeleteMapping("/delete/{seq}")
	public void delete(@PathVariable int seq) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		boardDAO.deleteBoard(vo);
	}
	
	@GetMapping("/read/{seq}")
	public String read(@PathVariable int seq) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		return boardDAO.getBoard(vo).toString();
	}
}
