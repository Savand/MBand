package com.andsav.gk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andsav.gk.entities.Band;
import com.andsav.gk.entities.ContactInfo;

public interface BandRepository extends JpaRepository<Band, Long>{

	Band findByContactInfo(ContactInfo contactInfo);
	
}
