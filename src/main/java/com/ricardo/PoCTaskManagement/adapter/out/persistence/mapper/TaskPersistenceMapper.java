package com.ricardo.PoCTaskManagement.adapter.out.persistence.mapper;

import com.ricardo.PoCTaskManagement.adapter.out.persistence.TaskEntity;
import com.ricardo.PoCTaskManagement.domain.model.Task;

public class TaskPersistenceMapper {

	private TaskPersistenceMapper() {
	}

	public static TaskEntity toEntity(Task task) {
		return new TaskEntity(task.getId(), task.getProjectId(), task.getTitle(), task.getDescription(), task.getAssigneeId(), task.getStatus());
	}

	public static Task toDomain(TaskEntity entity) {
		return new Task(entity.getId(), entity.getProjectId(), entity.getTitle(), entity.getDescription(), entity.getAssigneeId(), entity.getStatus());
	}
}