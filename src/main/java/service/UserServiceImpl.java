package service;

import domain.User;
import repository.UserDAO;
import repository.UserDAOImpl;

public class UserServiceImpl implements UserService {

	private UserDAO udao;
	
	public UserServiceImpl () {
		udao=new UserDAOImpl();
	}

	@Override
	public int join(User user) {
		// TODO Auto-generated method stub
		return udao.join(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return udao.login(user);
	}

	@Override
	public int lastLogin(String id) {
		// TODO Auto-generated method stub
		return udao.lastLogin(id);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return udao.update(user);
	}

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		return udao.delete(userId);
	}
}
