package com.tka;

public class User {
   
	private String username;
	private String password;
	private int  age;
	private String city;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, int age, String city) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", city=" + city + "]";
	}
	
	
}
