package controller;

import java.util.List;

import config.Model;
import model.Board;
import model.BoardRepository;

public class BoardController {
	
	private final BoardRepository boardRepository;
	
	public BoardController(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public String findAll(Model model) {
		System.out.println("findAll");
		List<Board> boardList = boardRepository.findAll();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
	public String findById(Model model) {
		System.out.println("findById");
		Board board = boardRepository.findbById();
		model.addAttribute("board", board);
		return "board/detail";
	}

}
