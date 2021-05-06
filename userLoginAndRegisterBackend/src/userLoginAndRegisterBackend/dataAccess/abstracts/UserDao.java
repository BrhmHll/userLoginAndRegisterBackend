package userLoginAndRegisterBackend.dataAccess.abstracts;

import userLoginAndRegisterBackend.entities.concretes.User;

public interface UserDao {

	void add(User user);
	void delete(User user);
	void update(User user);
	void get();
}
