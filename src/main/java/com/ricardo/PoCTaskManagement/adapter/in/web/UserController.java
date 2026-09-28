package com.ricardo.PoCTaskManagement.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ricardo.PoCTaskManagement.adapter.in.web.dto.CreateUserRequest;
import com.ricardo.PoCTaskManagement.adapter.in.web.dto.UserResponse;
import com.ricardo.PoCTaskManagement.adapter.in.web.mapper.TaskManagementMapper;
import com.ricardo.PoCTaskManagement.application.port.in.CreateUserUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	private final CreateUserUseCase createUserUseCase;

	public UserController(CreateUserUseCase createUserUseCase) {
		this.createUserUseCase = createUserUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponse create(@Valid @RequestBody CreateUserRequest request) {
		return TaskManagementMapper.toResponse(createUserUseCase.execute(request.name(), request.email()));
	}
}
