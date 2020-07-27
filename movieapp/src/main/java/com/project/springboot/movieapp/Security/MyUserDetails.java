package com.project.springboot.movieapp.Security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.springboot.movieapp.vo.entity.User;



public class MyUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4746285516124842670L;
	private String name;
	private String password;

	
	public MyUserDetails(User user) {

		this.name=user.getName();
		this.password=user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	public void setUserName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
