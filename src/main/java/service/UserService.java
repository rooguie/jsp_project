package service;

import domain.User;

public interface UserService {

	int join(User user);

	User login(User user);

	int lastLogin(String id);

	int update(User user);

	int delete(String userId);

}
