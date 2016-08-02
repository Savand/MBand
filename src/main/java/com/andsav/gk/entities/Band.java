package com.andsav.gk.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Band {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private BandBio bandBio;
	
	@OneToOne
	private ContactInfo contactInfo;
	
	@OneToMany
	private List<Musician> musicians;
	
	@Column
	private int publicRate;
	
	@Column(nullable= false)
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
