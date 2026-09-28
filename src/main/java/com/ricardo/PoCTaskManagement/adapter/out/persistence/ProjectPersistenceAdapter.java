package com.ricardo.PoCTaskManagement.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.ricardo.PoCTaskManagement.adapter.out.persistence.mapper.ProjectPersistenceMapper;
import com.ricardo.PoCTaskManagement.application.port.out.ProjectRepository;
import com.ricardo.PoCTaskManagement.domain.model.Project;

@Repository
public class ProjectPersistenceAdapter implements ProjectRepository {

	private final ProjectJpaRepository jpaRepository;

	public ProjectPersistenceAdapter(ProjectJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Project save(Project project) {
		ProjectEntity entity = ProjectPersistenceMapper.toEntity(project);
		ProjectEntity saved = jpaRepository.save(entity);
		return ProjectPersistenceMapper.toDomain(saved);
	}

	@Override
	public boolean existsById(Long id) {
		return jpaRepository.existsById(id);
	}
}