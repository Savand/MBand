package com.andsav.gk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andsav.gk.dto.SignupForm;
import com.andsav.gk.entities.Band;
import com.andsav.gk.entities.BandBio;
import com.andsav.gk.entities.ContactInfo;
import com.andsav.gk.repositories.BandRepository;

@Service
public class BandServiceImpl implements BandService{

	@Autowired
	private BandRepository repository;
	
	@Override
	public void signup(SignupForm signupform) {
		Band band = new Band();
		
		BandBio bbio = new BandBio();
		
		bbio.setMusicStyle(signupform.getMusicStyle());
		bbio.setName(signupform.getBandName());
		
		ContactInfo cinfo = new ContactInfo();
		
		cinfo.setEmail(signupform.getEmail());
		
		band.setBandBio(bbio);
		band.setContactInfo(cinfo);
		band.setPassword(signupform.getPassword());
		
		repository.save(band);
		
	}

}
