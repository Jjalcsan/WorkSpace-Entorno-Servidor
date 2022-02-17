package com.ejemplo.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nick;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private String address;
	private int age;
	private String profPic;
	
	
	public User() {}
	
	public User(String email, String password) {
		
		super();
		this.email = email;
		this.password = password;
		
	}
	
	public User(String nick, String password, String name, String surname, String phoneNumber, String email, String address, int age) {
		
		super();
		this.nick = nick;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.age = age;
		
	}
	
	public User(String nick, String password, String name, String surname, String phoneNumber, String email, String address, int age, String profPic) {
		
		super();
		this.nick = nick;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.age = age;
		this.profPic = profPic;
		
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getProfPic() {
		return profPic;
	}

	public void setProfPic(String profPic) {
		this.profPic = profPic;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, email, id, name, nick, password, phoneNumber, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(nick, other.nick)
				&& Objects.equals(password, other.password) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(surname, other.surname);
	}



	
	
}
