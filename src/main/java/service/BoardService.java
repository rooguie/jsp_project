package service;

import java.util.List;

import domain.Board;

public interface BoardService {

	int insert(Board board);

	List<Board> getList(Board boardList);

	Board detail(int bno);

	Board modify(int bno);

	int update(Board board);

	int delete(int bno);

	List<Board> getMyList(Board board);
	
	
}
