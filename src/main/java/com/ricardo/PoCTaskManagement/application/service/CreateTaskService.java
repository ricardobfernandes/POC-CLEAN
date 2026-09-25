package com.ricardo.PoCTaskManagement.application.service;

import com.ricardo.PoCTaskManagement.application.port.in.CreateTaskUseCase;
import com.ricardo.PoCTaskManagement.application.port.out.ProjectRepository;
import com.ricardo.PoCTaskManagement.application.port.out.TaskRepository;
import com.ricardo.PoCTaskManagement.domain.exception.ResourceNotFoundException;
import com.ricardo.PoCTaskManagement.domain.model.Task;
import com.ricardo.PoCTaskManagement.domain.model.TaskStatus;

public class CreateTaskService implements CreateTaskUseCase {

	private final ProjectRepository projectRepository;
	private final TaskRepository taskRepository;

	public CreateTaskService(ProjectRepository projectRepository, TaskRepository taskRepository) {
		this.projectRepository = projectRepository;
		this.taskRepository = taskRepository;
	}

	@Override
	public Task execute(Long projectId, String title, String description) {
		if (!projectRepository.existsById(projectId)) {
			throw new ResourceNotFoundException("Project not found");
		}
		Task task = new Task(null, projectId, title, description, null, TaskStatus.TODO);
		return taskRepository.save(task);
	}
}
