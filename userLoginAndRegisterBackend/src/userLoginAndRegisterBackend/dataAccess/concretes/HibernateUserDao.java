package userLoginAndRegisterBackend.dataAccess.concretes;

import userLoginAndRegisterBackend.dataAccess.abstracts.UserDao;
import userLoginAndRegisterBackend.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile veritabanına eklendi: " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile veritabanından silindi: " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile güncelendi: " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void get() {
		// Get to data for request
		
	}

	
}
