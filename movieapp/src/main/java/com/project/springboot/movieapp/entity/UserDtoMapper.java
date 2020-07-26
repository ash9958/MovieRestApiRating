package com.project.springboot.movieapp.entity;

import java.util.ArrayList;
import java.util.List;

import com.project.springboot.movieapp.entity.User;

public class UserDtoMapper {
	public UserDto getUserToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		return userDto;
	}

	public User getDtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		return user;
	}

	public List<UserDto> getUserToDtoList(List<User> users) {
		List<UserDto> userDtos = new ArrayList<UserDto>();
		users.forEach(user ->{
			userDtos.add(getUserToDto(user));
		});
		return userDtos;
	}

	public List<User> getDtoToUserList(List<UserDto> userDtos) {
		List<User> users = new ArrayList<User>();
		userDtos.forEach(userDto ->{
			users.add(getDtoToUser(userDto));
		});
		return users;
	}
}
