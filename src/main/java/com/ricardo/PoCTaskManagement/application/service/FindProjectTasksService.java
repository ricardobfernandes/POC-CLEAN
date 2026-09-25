package com.ricardo.PoCTaskManagement.application.service;

import java.util.List;

import com.ricardo.PoCTaskManagement.application.port.in.FindProjectTasksUseCase;
import com.ricardo.PoCTaskManagement.application.port.out.ProjectRepository;
import com.ricardo.PoCTaskManagement.application.port.out.TaskRepository;
import com.ricardo.PoCTaskManagement.domain.exception.ResourceNotFoundException;
import com.ricardo.PoCTaskManagement.domain.model.Task;

public class FindProjectTasksService implements FindProjectTasksUseCase {

	private final ProjectRepository projectRepository;
	private final TaskRepository taskRepository;

	public FindProjectTasksService(ProjectRepository projectRepository, TaskRepository taskRepository) {
		this.projectRepository = projectRepository;
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> execute(Long projectId) {
		if (!projectRepository.existsById(projectId)) {
			throw new ResourceNotFoundException("Project not found");
		}
		return taskRepository.findByProjectId(projectId);
	}
}
