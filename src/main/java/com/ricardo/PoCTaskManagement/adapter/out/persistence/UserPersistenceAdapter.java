package com.ricardo.PoCTaskManagement.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.ricardo.PoCTaskManagement.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.ricardo.PoCTaskManagement.application.port.out.UserRepository;
import com.ricardo.PoCTaskManagement.domain.model.User;

@Repository
public class UserPersistenceAdapter implements UserRepository {

	private final UserJpaRepository jpaRepository;

	public UserPersistenceAdapter(UserJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public User save(User user) {
		UserEntity entity = UserPersistenceMapper.toEntity(user);
		UserEntity saved = jpaRepository.save(entity);
		return UserPersistenceMapper.toDomain(saved);
	}

	@Override
	public boolean existsById(Long id) {
		return jpaRepository.existsById(id);
	}
}