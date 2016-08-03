package com.andsav.gk.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.andsav.gk.dto.SignupForm;
import com.andsav.gk.entities.ContactInfo;
import com.andsav.gk.repositories.ContactInfoRepository;

@Component
public class SignUpFormValidator extends LocalValidatorFactoryBean{

	private ContactInfoRepository contactInfoRepository;
	
	@Resource
	public void setContactInfoRepository(ContactInfoRepository contactInfoRepository) {
		this.contactInfoRepository = contactInfoRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(SignupForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors, Object... validationHints) {
		super.validate(obj, errors, validationHints);
		
		SignupForm form = (SignupForm)obj;
		
		ContactInfo contactInfo = contactInfoRepository.findByEmail(form.getEmail());
		
		if(contactInfo != null){
			errors.rejectValue("email", "emailNotUnique");
		}
		
		
	}
	
	
}
