package repository;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.User;
import orm.DataBaseBuilder;

public class UserDAOImpl implements UserDAO {

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	SqlSession sql;
	
	public UserDAOImpl() {
		new DataBaseBuilder();
		sql=DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int join(User user) {
		log.info("userDAO");
		int isOk=sql.insert("userMapper.join",user);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		log.info("userDAO");
		return sql.selectOne("userMapper.login",user);
	}

	@Override
	public int lastLogin(String id) {
		// TODO Auto-generated method stub
		log.info("lastLogin DAO id >> {}",id);
		int isOk=sql.update("userMapper.lastLoginUpdate",id);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		log.info("udateDAO");
		int isOk=sql.update("userMapper.userUpdate",user);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		log.info("deleteDAO userId=>{}", userId);
		int isOk=sql.delete("userMapper.deleteUser",userId);
		if(isOk>0) sql.commit();
		return isOk;
	}
	
}
