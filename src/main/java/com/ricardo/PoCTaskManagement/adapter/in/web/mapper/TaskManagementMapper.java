package com.ricardo.PoCTaskManagement.adapter.in.web.mapper;

import com.ricardo.PoCTaskManagement.adapter.in.web.dto.ProjectResponse;
import com.ricardo.PoCTaskManagement.adapter.in.web.dto.TaskResponse;
import com.ricardo.PoCTaskManagement.adapter.in.web.dto.UserResponse;
import com.ricardo.PoCTaskManagement.domain.model.Project;
import com.ricardo.PoCTaskManagement.domain.model.Task;
import com.ricardo.PoCTaskManagement.domain.model.User;

public class TaskManagementMapper {

	private TaskManagementMapper() {
	}

	public static ProjectResponse toResponse(Project project) {
		return new ProjectResponse(project.getId(), project.getName());
	}

	public static UserResponse toResponse(User user) {
		return new UserResponse(user.getId(), user.getName(), user.getEmail());
	}

	public static TaskResponse toResponse(Task task) {
		return new TaskResponse(task.getId(), task.getProjectId(), task.getTitle(), task.getDescription(), task.getAssigneeId(), task.getStatus());
	}
}
