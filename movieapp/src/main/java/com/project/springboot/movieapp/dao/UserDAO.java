package com.project.springboot.movieapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.movieapp.vo.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	public Optional<User> findByName(String name);
}
