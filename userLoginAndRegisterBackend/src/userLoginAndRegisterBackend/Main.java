package userLoginAndRegisterBackend;

import userLoginAndRegisterBackend.business.abstracts.UserService;
import userLoginAndRegisterBackend.business.concretes.UserManager;
import userLoginAndRegisterBackend.core.GoogleLoginServiceAdapter;
import userLoginAndRegisterBackend.core.LoginService;
import userLoginAndRegisterBackend.dataAccess.concretes.HibernateUserDao;
import userLoginAndRegisterBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User("İbrahim Halil", "SAKAR", "halil0007644@gmail.com", "123456");
		User user2 = new User("İbrahim Halil", "SAKAR", "halil0007644@gmail.com", "12345");
		User user3 = new User("İbrahim Halil", "SAKAR", "halil0007644gmail.com", "123456");
		User user4 = new User("İbrahim Halil", "SA", "halil0007644@gmail.com", "123456");
		
		
		registerTest(user1);
		registerTest(user2);
		registerTest(user3);
		registerTest(user4);
		
		loginTest(user1);
		loginTest(user2);
		loginTest(user3);
		loginTest(user4);
		
		LoginService loginService = new GoogleLoginServiceAdapter();
		
		loginService.register();
		loginService.login();
		
	}
	
	private static void registerTest(User user) {
		UserService userService = new UserManager(new HibernateUserDao());
		
		boolean isSuccess = userService.register(user);
		if (isSuccess) {
			System.out.println("E-posta onaylanmayı bekliyor!");
			
			boolean isEmailTrue = userService.emailVerification(user);
			if (isEmailTrue) {
				System.out.println("Kayıt başarılı!");
			}
			else {
				System.out.println("Kayıt başarısız!");
			}
		}
		else {
			System.out.println("Kayıt başarısız!");
		}
		
		
		
		
		System.out.println("---------------------------------");
	}
	
	private static void loginTest(User user) {
		UserService userService = new UserManager(new HibernateUserDao());
		
		boolean isSuccess = userService.login(user);
		if (isSuccess) {
			System.out.println("Başarıyla giriş yapıldı!");
		}
		else {
			System.out.println("Giriş başarısız!");
		}
		System.out.println("---------------------------------");
		
	}

}
