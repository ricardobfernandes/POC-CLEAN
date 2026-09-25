package com.ricardo.PoCTaskManagement.application.service;

import com.ricardo.PoCTaskManagement.application.port.in.ChangeTaskStatusUseCase;
import com.ricardo.PoCTaskManagement.application.port.out.TaskRepository;
import com.ricardo.PoCTaskManagement.domain.exception.ResourceNotFoundException;
import com.ricardo.PoCTaskManagement.domain.model.Task;
import com.ricardo.PoCTaskManagement.domain.model.TaskStatus;

public class ChangeTaskStatusService implements ChangeTaskStatusUseCase {

	private final TaskRepository taskRepository;

	public ChangeTaskStatusService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Task execute(Long taskId, TaskStatus status) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
		task.changeStatus(status);
		return taskRepository.save(task);
	}
}
