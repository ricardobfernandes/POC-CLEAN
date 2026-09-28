package com.ricardo.PoCTaskManagement.adapter.out.persistence.mapper;

import com.ricardo.PoCTaskManagement.adapter.out.persistence.ProjectEntity;
import com.ricardo.PoCTaskManagement.domain.model.Project;

public class ProjectPersistenceMapper {

	private ProjectPersistenceMapper() {
	}

	public static ProjectEntity toEntity(Project project) {
		return new ProjectEntity(project.getId(), project.getName());
	}

	public static Project toDomain(ProjectEntity entity) {
		return new Project(entity.getId(), entity.getName());
	}
}