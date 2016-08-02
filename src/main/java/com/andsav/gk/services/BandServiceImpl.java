package com.andsav.gk.services;

import com.andsav.gk.dto.SignupForm;
import com.andsav.gk.entities.Band;

public class BandServiceImpl implements BandService{

	@Override
	public void signup(SignupForm signupform) {
		Band band = new Band();
		
		band.getBandBio().setName(signupform.getBandName());
		band.getBandBio().setMusicStyle(signupform.getMusicStyle());
		band.getContactInfo().setEmail(signupform.getEmail());
		band.setPassword(signupform.getPassword());
		
	}

}
