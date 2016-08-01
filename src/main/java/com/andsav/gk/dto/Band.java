package com.andsav.gk.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class Band {
	private BandBio bandBio;
	private ContactInfo contactInfo;
	private List<Musician> musicians;
	private int publicRate;
	
	@NotNull
	private String password;
	

	public BandBio getBandBio() {
		return bandBio;
	}
	
	public void setBandBio(BandBio bandBio) {
		this.bandBio = bandBio;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public List<Musician> getMusicians() {
		return musicians;
	}
	public void setMusicians(List<Musician> musicians) {
		this.musicians = musicians;
	}
	public int getPublicRate() {
		return publicRate;
	}
	public void setPublicRate(int publicRate) {
		this.publicRate = publicRate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Band [bandBio=" + bandBio + ", contactInfo=" + contactInfo + ", musicians=" + musicians
				+ ", publicRate=" + publicRate + ", password=" + password + "]";
	}
	

}
