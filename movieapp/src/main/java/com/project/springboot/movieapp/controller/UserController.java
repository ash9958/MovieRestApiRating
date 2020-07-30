package com.project.springboot.movieapp.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.movieapp.dao.UserDAO;
import com.project.springboot.movieapp.vo.entity.User;

@RestController
public class UserController {

	@Autowired
	UserDAO userDao;

	@GetMapping(value = { "/user", "/" })
	public String getUser(Principal principal) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(
				() -> new UsernameNotFoundException("No User available with the name -" + principal.getName()));

		return "Successfully Logged In";
	}
}