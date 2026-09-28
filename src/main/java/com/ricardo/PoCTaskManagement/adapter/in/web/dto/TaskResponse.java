package com.ricardo.PoCTaskManagement.adapter.in.web.dto;

import com.ricardo.PoCTaskManagement.domain.model.TaskStatus;

public record TaskResponse(Long id, Long projectId, String title, String description, Long assigneeId, TaskStatus status) {
	
}