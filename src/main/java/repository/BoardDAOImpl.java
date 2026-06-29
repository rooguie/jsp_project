package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Board;
import orm.DataBaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAO.class);
	SqlSession sql;
	
	public BoardDAOImpl () {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(Board board) {
		log.info(">> BoardDAO Insert >> ");
		int isOk = sql.insert("boardMapper.add", board);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public List<Board> getList(Board boardList) {
		// TODO Auto-generated method stub
		return sql.selectList("boardMapper.selectList",boardList);
	}

	@Override
	public Board detail(int bno) {
		// TODO Auto-generated method stub
		log.info("DAO detail bno=>{}",bno);
		
		return sql.selectOne("boardMapper.detail",bno);
	}

	@Override
	public Board modify(int bno) {
		// TODO Auto-generated method stub
		log.info("DAO modify");
		return sql.selectOne("boardMapper.modify",bno);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		log.info("DAO update");
		int isOk=sql.insert("boardMapper.update",board);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		log.info("DAO delete");
		int isOk =sql.delete("boardMapper.delete",bno);
		return isOk;
	}

	@Override
	public List<Board> getMyList(Board board) {
		// TODO Auto-generated method stub
		log.info("myListDAO");
		return sql.selectList("boardMapper.myList",board);
	}

}
