package model;

import java.util.Arrays;
import java.util.List;

public class BoardRepository {
	public List<Board> findAll(){
		return Arrays.asList(newBoard(1), newBoard(2), newBoard(3));
	}
	
	public Board findbById(){
		return null;
	}
	
	//dummy
	private Board newBoard(int id) {
		Board board = new Board();
		board.setId(id);
		board.setTitle("title"+id);
		board.setUserId(1);
		return board;
	}
	
}
