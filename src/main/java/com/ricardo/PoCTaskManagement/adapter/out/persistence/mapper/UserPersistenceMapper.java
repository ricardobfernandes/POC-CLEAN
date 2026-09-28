package com.ricardo.PoCTaskManagement.adapter.out.persistence.mapper;

import com.ricardo.PoCTaskManagement.adapter.out.persistence.UserEntity;
import com.ricardo.PoCTaskManagement.domain.model.User;

public class UserPersistenceMapper {

	private UserPersistenceMapper() {
	}

	public static UserEntity toEntity(User user) {
		return new UserEntity(user.getId(), user.getName(), user.getEmail());
	}

	public static User toDomain(UserEntity entity) {
		return new User(entity.getId(), entity.getName(), entity.getEmail());
	}
}