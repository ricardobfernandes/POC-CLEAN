package com.ricardo.PoCTaskManagement.application.service;

import com.ricardo.PoCTaskManagement.application.port.in.AssignTaskUseCase;
import com.ricardo.PoCTaskManagement.application.port.out.TaskRepository;
import com.ricardo.PoCTaskManagement.application.port.out.UserRepository;
import com.ricardo.PoCTaskManagement.domain.exception.ResourceNotFoundException;
import com.ricardo.PoCTaskManagement.domain.model.Task;

public class AssignTaskService implements AssignTaskUseCase {

	private final TaskRepository taskRepository;
	private final UserRepository userRepository;

	public AssignTaskService(TaskRepository taskRepository, UserRepository userRepository) {
		this.taskRepository = taskRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Task execute(Long taskId, Long userId) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found"));

		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found");
		}
		task.assignTo(userId);
		return taskRepository.save(task);
	}
}
