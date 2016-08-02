package com.andsav.gk.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BandBio {
	
	@NotNull
	@Size(min=1, max=55)
	private String name;
	
	private MusicStyle musicStyle;
	private MediaBio mediaBio;
	private String shortDescription;
	
	
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
