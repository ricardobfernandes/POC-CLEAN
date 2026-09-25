package com.ricardo.PoCTaskManagement.application.port.in;

import com.ricardo.PoCTaskManagement.domain.model.User;

public interface CreateUserUseCase {

	User execute(String name, String email);
}
