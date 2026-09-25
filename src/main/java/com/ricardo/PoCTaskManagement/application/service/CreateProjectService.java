package com.ricardo.PoCTaskManagement.application.service;

import com.ricardo.PoCTaskManagement.application.port.in.CreateProjectUseCase;
import com.ricardo.PoCTaskManagement.application.port.out.ProjectRepository;
import com.ricardo.PoCTaskManagement.domain.model.Project;

public class CreateProjectService implements CreateProjectUseCase {

	private final ProjectRepository projectRepository;

	public CreateProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public Project execute(String name) {
		Project project = new Project(null, name);
		return projectRepository.save(project);
	}
}