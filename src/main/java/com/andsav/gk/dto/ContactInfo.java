package com.andsav.gk.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ContactInfo {
	
	@NotEmpty
	@Email
	private String email;
	
	private String city;
	
	private String phoneNumber;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public String toString() {
		return "ContactInfo [email=" + email + ", city=" + city + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
