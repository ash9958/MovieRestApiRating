package com.project.springboot.movieapp.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.springboot.movieapp.dao.UserDAO;
import com.project.springboot.movieapp.vo.entity.User;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		Optional<User> user = userDao.findByName(name);
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		return new MyUserDetails(user.get());

	}


	

}
