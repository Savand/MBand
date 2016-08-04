package com.andsav.gk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="band_biography")
public class BandBio {
	
	private static final int NAME_MAX_LENGTH = 55;

	private static final int SHORT_DESR__MAX_LENGTH = 1024;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable= false, length=NAME_MAX_LENGTH)
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	private MusicStyle musicStyle;
	
	@OneToOne(fetch = FetchType.LAZY)
	private MediaBio mediaBio;
	
	@Column(length=SHORT_DESR__MAX_LENGTH)
	private String shortDescription;
	
	
	
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MusicStyle getMusicStyle() {
		return musicStyle;
	}
	public void setMusicStyle(MusicStyle musicStyle) {
		this.musicStyle = musicStyle;
	}
	public MediaBio getMediaBio() {
		return mediaBio;
	}
	public void setMediaBio(MediaBio mediaBio) {
		this.mediaBio = mediaBio;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
	@Override
	public String toString() {
		return "BandBio [name=" + name + ", musicStyle=" + musicStyle + ", mediaBio=" + mediaBio + ", shortDescription="
				+ shortDescription + "]";
	}
	

}
