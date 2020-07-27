package com.project.springboot.movieapp.vo.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.project.springboot.movieapp.vo.dto.UserDto;
import com.project.springboot.movieapp.vo.entity.User;

public class UserDtoMapper {
	public UserDto getDtoFromUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		return userDto;
	}

	public User getUserFromDto(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		return user;
	}

	public List<UserDto> getDtoListFromUserLists(List<User> users) {
		List<UserDto> userDtos = new ArrayList<UserDto>();
		users.forEach(user ->{
			userDtos.add(getDtoFromUser(user));
		});
		return userDtos;
	}

	public List<User> getUserListFromDtoList(List<UserDto> userDtos) {
		List<User> users = new ArrayList<User>();
		userDtos.forEach(userDto ->{
			users.add(getUserFromDto(userDto));
		});
		return users;
	}
}
