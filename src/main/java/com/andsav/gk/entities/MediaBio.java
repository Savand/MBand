package com.andsav.gk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="media_biography")
public class MediaBio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private Byte[] bandImage;
	
	@Lob
	private Byte[] demoTrack;
	
	@Lob
	private Byte[] biography;
	
	
	public Byte[] getBandImage() {
		return bandImage;
	}
	public void setBandImage(Byte[] bandImage) {
		this.bandImage = bandImage;
	}
	public Byte[] getDemoTrack() {
		return demoTrack;
	}
	public void setDemoTrack(Byte[] demoTrack) {
		this.demoTrack = demoTrack;
	}
	public Byte[] getBiography() {
		return biography;
	}
	public void setBiography(Byte[] biography) {
		this.biography = biography;
	}
}
