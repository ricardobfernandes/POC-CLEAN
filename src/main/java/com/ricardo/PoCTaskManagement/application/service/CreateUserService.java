package com.ricardo.PoCTaskManagement.application.service;

import com.ricardo.PoCTaskManagement.application.port.in.CreateUserUseCase;
import com.ricardo.PoCTaskManagement.application.port.out.UserRepository;
import com.ricardo.PoCTaskManagement.domain.model.User;

public class CreateUserService implements CreateUserUseCase {

	private final UserRepository userRepository;

	public CreateUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User execute(String name, String email) {
		User user = new User(null, name, email);
		return userRepository.save(user);
	}
}