package model;



import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegUser {

	
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String country;
	private String stateProv;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStateProv() {
		return stateProv;
	}
	public void setStateProv(String stateProv) {
		this.stateProv = stateProv;
	}
	public RegUser(String name, String password, String email, String country, String stateProv) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
		this.stateProv = stateProv;
	}
	
	
	public RegUser() {
		super();
	}
	

	
	
	

	
	
}
