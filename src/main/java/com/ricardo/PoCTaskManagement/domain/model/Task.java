package com.ricardo.PoCTaskManagement.domain.model;

import com.ricardo.PoCTaskManagement.domain.exception.InvalidTaskException;

public class Task {

	private Long id;
	private Long projectId;
	private String title;
	private String description;
	private Long assigneeId;
	private TaskStatus status;

	public Task(Long id, Long projectId, String title, String description, Long assigneeId, TaskStatus status) {
		if (projectId == null || projectId <= 0) {
			throw new InvalidTaskException("Project is required");
		}
		if (title == null || title.isBlank()) {
			throw new InvalidTaskException("Task title is required");
		}
		this.id = id;
		this.projectId = projectId;
		this.title = title;
		this.description = description;
		this.assigneeId = assigneeId;
		this.status = status == null ? TaskStatus.TODO : status;
	}

	public void assignTo(Long userId) {
		if (userId == null || userId <= 0) {
			throw new InvalidTaskException("Valid user ID is required");
		}
		this.assigneeId = userId;
	}

	public void changeStatus(TaskStatus newStatus) {
		if (newStatus == null) {
			throw new InvalidTaskException("Task status is required");
		}
		this.status = newStatus;
	}
	
	public Long getId() {
		return id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public TaskStatus getStatus() {
		return status;
	}
}
