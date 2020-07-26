package com.project.springboot.movieapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.movieapp.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
