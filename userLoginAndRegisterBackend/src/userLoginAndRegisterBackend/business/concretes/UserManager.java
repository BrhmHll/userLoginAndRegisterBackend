package userLoginAndRegisterBackend.business.concretes;
import userLoginAndRegisterBackend.business.abstracts.UserService;
import userLoginAndRegisterBackend.dataAccess.abstracts.UserDao;
import userLoginAndRegisterBackend.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao _userDao;
	private String regexCode = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	
	public UserManager(UserDao userDao) {
		super();
		this._userDao = userDao;
	}
	
	@Override
	public boolean register(User user) {
		if(!mailAndPasswordCheck(user)) {
			return false;
		}
		
		if (user.getFirstName().isEmpty() ||
				user.getLastName().isEmpty()) {
			System.out.println("Bilgiler boş bırakılamaz!");
			return false;
		}
		if (user.getFirstName().length() < 3 || 
				user.getLastName().length() < 3) {
			System.out.println("İsim ve soyisim 2 karakterden uzun olmalıdır!");
			return false;
		}
		
		System.out.println("Email gönderildi lütfen maillerinizi kontrol edip onaylayınız.");
		return true;
		
	}

	@Override
	public boolean login(User user) {

		if(!mailAndPasswordCheck(user)) {
			return false;
		}
		
		// Burası normalde veritabanından işlemi kontrol eder 
		// ama şu an çalışmadığı için devredışı!
		/*
		User gettedUser = _userDao.get(i => i.EPosta == user.getEPosta());
		if (gettedUser == null) {
			System.out.println("Böyle bir kullanıcı bulunamadı!");
			return false;
		}
		else if(gettedUser.getPassword() != gettedUser.getPassword()) {
			System.out.println("Hatalı bir şifre girdiniz!");
			return false;
		}
		*/
		// Bilgiler doğru varsayıyoruz
		System.out.println("Giriş başarılı!");
		return true;
	}
	

	@Override
	public boolean emailVerification(User user) {
		// TODO Auto-generated method stub
		System.out.println("E-Posta onaylandı. Sisteme kaydınız tamamlanmıştır.");
		_userDao.add(user);
		return true;
	}
	
	// Business Rules
	
	private boolean mailAndPasswordCheck(User user) {
		
		if (user.getEPosta().isEmpty() || user.getPassword().isEmpty()) {
			System.out.println("E-mail veya şifre boş bırakılamaz!");
			return false;
		}
		
		if (user.getPassword().length() < 6) {
			System.out.println("Şifre en az 6 haneli olmalı!");
			return false;
		}
		if (!user.getEPosta().matches(regexCode)) {
			System.out.println("Geçersiz e-posta girdiniz!");
			return false;
		}
		return true;
	}
	

	

}
