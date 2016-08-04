package com.andsav.gk.dto;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.andsav.gk.entities.Band;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Band band;
	
	
	public UserDetailsImpl(Band band) {
		this.band = band;
	}
	

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<>(1);
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return band.getPassword();
	}

	@Override
	public String getUsername() {
		return band.getContactInfo().getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
