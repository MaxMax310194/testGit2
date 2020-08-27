package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="country")
	private String country;
	@Column(name="stateProv")
	private String stateProv;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public User() {
		super();
	}
	public User(String name, String password, String email, String country, String stateProv) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
		this.stateProv = stateProv;
	}
	public User(int id, String name, String password, String email, String country, String stateProv) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
		this.stateProv = stateProv;
	}
	@Override
	public String toString() {
		return "LogUser [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", country="
				+ country + ", stateProv=" + stateProv + "]";
	}
	
	
}
