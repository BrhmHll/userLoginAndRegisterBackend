package userLoginAndRegisterBackend.business.abstracts;

import userLoginAndRegisterBackend.entities.concretes.User;

public interface UserService {

	boolean register(User user);
	boolean login(User user);
	boolean emailVerification(User user);
}
