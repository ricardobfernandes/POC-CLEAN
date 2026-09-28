package com.ricardo.PoCTaskManagement.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ricardo.PoCTaskManagement.adapter.in.web.dto.CreateProjectRequest;
import com.ricardo.PoCTaskManagement.adapter.in.web.dto.ProjectResponse;
import com.ricardo.PoCTaskManagement.adapter.in.web.mapper.TaskManagementMapper;
import com.ricardo.PoCTaskManagement.application.port.in.CreateProjectUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	private final CreateProjectUseCase createProjectUseCase;

	public ProjectController(CreateProjectUseCase createProjectUseCase) {
		this.createProjectUseCase = createProjectUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProjectResponse create(@Valid @RequestBody CreateProjectRequest request) {
		return TaskManagementMapper.toResponse(createProjectUseCase.execute(request.name()));
	}

}
