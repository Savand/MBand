package com.andsav.gk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andsav.gk.dto.SignupForm;
import com.andsav.gk.dto.UserDetailsImpl;
import com.andsav.gk.entities.Band;
import com.andsav.gk.entities.BandBio;
import com.andsav.gk.entities.ContactInfo;
import com.andsav.gk.repositories.BandRepository;
import com.andsav.gk.repositories.ContactInfoRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class BandServiceImpl implements BandService, UserDetailsService{

	private BandRepository bandRepository;
	private ContactInfoRepository contactInfoRepository; 
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	public BandServiceImpl(BandRepository bandRepository, ContactInfoRepository contactInfoRepository, PasswordEncoder passwordEncoder) {
		this.bandRepository = bandRepository;
		this.contactInfoRepository = contactInfoRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void signup(SignupForm signupform) {
		Band band = new Band();
		
		BandBio bbio = new BandBio();
		
		bbio.setMusicStyle(signupform.getMusicStyle());
		bbio.setName(signupform.getBandName());
		
		ContactInfo cinfo = new ContactInfo();
		
		cinfo.setEmail(signupform.getEmail());
		
		band.setBandBio(bbio);
		band.setContactInfo(cinfo);
		band.setPassword(passwordEncoder.encode(signupform.getPassword()));
		
		bandRepository.save(band);
		
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		ContactInfo contactInfo = contactInfoRepository.findByEmail(userName);
		
		if (contactInfo == null){
			
			throw new UsernameNotFoundException(userName);

		} else {
			
			Band band = bandRepository.findByContactInfo(contactInfo);
			
			if (band == null)
				throw new UsernameNotFoundException(userName);
			
			return new UserDetailsImpl(band);
		}
		
	}

}
