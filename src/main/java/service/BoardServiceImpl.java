package service;

import java.util.List;

import domain.Board;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {

	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao=new BoardDAOImpl();
	}
	
	@Override
	public int insert(Board board) {
		// TODO Auto-generated method stub
		return bdao.insert(board);
	}

//	@Override
//	public List<Board> getList(Board boardList) {
//		// TODO Auto-generated method stub
//		return bdao.getList(boardList);
//	}

	@Override
	public Board detail(int bno) {
		// TODO Auto-generated method stub
		return bdao.detail(bno);
	}

	@Override
	public Board modify(int bno) {
		// TODO Auto-generated method stub
		return bdao.modify(bno);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return bdao.update(board);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return bdao.delete(bno);
	}

	@Override
	public List<Board> getMyList(Board board) {
		// TODO Auto-generated method stub
		return bdao.getMyList(board);
	}

	@Override
	public List<Board> getList(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		return bdao.getList(pagingVO);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return bdao.getTotal();
	}

}
