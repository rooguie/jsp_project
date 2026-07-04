package service;

import java.util.List;

import domain.Board;
import domain.PagingVO;

public interface BoardService {


	int insert(Board board);

	List<Board> getList(PagingVO pagingVO);

	Board detail(int bno);

	Board modify(int bno);

	int update(Board board);

	int delete(int bno);

	List<Board> getMyList(Board board);

	int getTotal();
	
	
}
