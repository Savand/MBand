package com.andsav.gk.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.andsav.gk.entities.MusicStyle;

//TODO add another properties

public class SignupForm {
	
	@NotNull
	@Size(min=1, max=55, message="{nameSizeError}")
	private String bandName;
	private MusicStyle musicStyle;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Size(min=4)
	private String password;

	
	
	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public MusicStyle getMusicStyle() {
		return musicStyle;
	}

	public void setMusicStyle(MusicStyle musicStyle) {
		this.musicStyle = musicStyle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignupForm [bandName=" + bandName + ", musicStyle=" + musicStyle + ", email=" + email + ", password="
				+ password + "]";
	}

	
	
	
}
