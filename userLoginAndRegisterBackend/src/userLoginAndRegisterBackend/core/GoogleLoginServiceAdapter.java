package userLoginAndRegisterBackend.core;

import userLoginAndRegisterBackend.googleLogin.GoogleLoginService;

public class GoogleLoginServiceAdapter implements LoginService{

	
	@Override
	public void login() {
		GoogleLoginService loginService = new GoogleLoginService();
		loginService.loginWithGoogle();
		
	}

	@Override
	public void register() {
		GoogleLoginService loginService = new GoogleLoginService();
		loginService.registerWithGoogle();
	}

}
