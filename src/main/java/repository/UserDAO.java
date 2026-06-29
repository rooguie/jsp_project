package repository;

import domain.User;

public interface UserDAO {

	int join(User user);

	User login(User user);

	int lastLogin(String id);

	int update(User user);

	int delete(String userId);

}
