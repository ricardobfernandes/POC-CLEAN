package com.ricardo.PoCTaskManagement.adapter.in.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ricardo.PoCTaskManagement.adapter.in.web.dto.AssignTaskRequest;
import com.ricardo.PoCTaskManagement.adapter.in.web.dto.ChangeTaskStatusRequest;
import com.ricardo.PoCTaskManagement.adapter.in.web.dto.CreateTaskRequest;
import com.ricardo.PoCTaskManagement.adapter.in.web.dto.TaskResponse;
import com.ricardo.PoCTaskManagement.adapter.in.web.mapper.TaskManagementMapper;
import com.ricardo.PoCTaskManagement.application.port.in.AssignTaskUseCase;
import com.ricardo.PoCTaskManagement.application.port.in.ChangeTaskStatusUseCase;
import com.ricardo.PoCTaskManagement.application.port.in.CreateTaskUseCase;
import com.ricardo.PoCTaskManagement.application.port.in.FindProjectTasksUseCase;

import jakarta.validation.Valid;

@RestController
public class TaskController {

	private final CreateTaskUseCase createTaskUseCase;
	private final AssignTaskUseCase assignTaskUseCase;
	private final ChangeTaskStatusUseCase changeTaskStatusUseCase;
	private final FindProjectTasksUseCase findProjectTasksUseCase;

	public TaskController(CreateTaskUseCase createTaskUseCase, AssignTaskUseCase assignTaskUseCase,
			ChangeTaskStatusUseCase changeTaskStatusUseCase, FindProjectTasksUseCase findProjectTasksUseCase) {
		this.createTaskUseCase = createTaskUseCase;
		this.assignTaskUseCase = assignTaskUseCase;
		this.changeTaskStatusUseCase = changeTaskStatusUseCase;
		this.findProjectTasksUseCase = findProjectTasksUseCase;
	}

	@PostMapping("/projects/{projectId}/tasks")
	@ResponseStatus(HttpStatus.CREATED)
	public TaskResponse create(@PathVariable Long projectId, @Valid @RequestBody CreateTaskRequest request) {
		return TaskManagementMapper.toResponse(createTaskUseCase.execute(projectId, request.title(), request.description()));
	}

	@PatchMapping("/tasks/{taskId}/assignee")
	public TaskResponse assign(@PathVariable Long taskId, @Valid @RequestBody AssignTaskRequest request) {
		return TaskManagementMapper.toResponse(assignTaskUseCase.execute(taskId, request.userId()));
	}

	@PatchMapping("/tasks/{taskId}/status")
	public TaskResponse changeStatus(@PathVariable Long taskId, @Valid @RequestBody ChangeTaskStatusRequest request) {
		return TaskManagementMapper.toResponse(changeTaskStatusUseCase.execute(taskId, request.status()));
	}

	@GetMapping("/projects/{projectId}/tasks")
	public List<TaskResponse> findByProject(@PathVariable Long projectId) {
		return findProjectTasksUseCase.execute(projectId).stream().map(TaskManagementMapper::toResponse).toList();
	}
}
