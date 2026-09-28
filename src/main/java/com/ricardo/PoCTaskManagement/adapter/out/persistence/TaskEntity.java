package com.ricardo.PoCTaskManagement.adapter.out.persistence;

import com.ricardo.PoCTaskManagement.domain.model.TaskStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long projectId;
	private String title;
	private String description;
	private Long assigneeId;

	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	protected TaskEntity() {
	}

	public TaskEntity(Long id, Long projectId, String title, String description, Long assigneeId, TaskStatus status) {
		this.id = id;
		this.projectId = projectId;
		this.title = title;
		this.description = description;
		this.assigneeId = assigneeId;
		this.status = status;
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