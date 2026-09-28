package com.ricardo.PoCTaskManagement.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ricardo.PoCTaskManagement.adapter.out.persistence.mapper.TaskPersistenceMapper;
import com.ricardo.PoCTaskManagement.application.port.out.TaskRepository;
import com.ricardo.PoCTaskManagement.domain.model.Task;

@Repository
public class TaskPersistenceAdapter implements TaskRepository {

	private final TaskJpaRepository jpaRepository;

	public TaskPersistenceAdapter(TaskJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Task save(Task task) {
		TaskEntity entity = TaskPersistenceMapper.toEntity(task);
		TaskEntity saved = jpaRepository.save(entity);
		return TaskPersistenceMapper.toDomain(saved);
	}

	@Override
	public Optional<Task> findById(Long id) {
		return jpaRepository.findById(id).map(TaskPersistenceMapper::toDomain);
	}

	@Override
	public List<Task> findByProjectId(Long projectId) {
		return jpaRepository.findByProjectId(projectId).stream().map(TaskPersistenceMapper::toDomain).toList();
	}
}