package userLoginAndRegisterBackend.entities.concretes;

public class User {

	private String firstName;
	private String lastName;
	private String ePosta;
	private String password;
	
	public User(String firstName, String lastName, String ePosta, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ePosta = ePosta;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEPosta() {
		return ePosta;
	}

	public void setEPosta(String ePosta) {
		this.ePosta = ePosta;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
