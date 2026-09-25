package com.ricardo.PoCTaskManagement.application.port.in;

import com.ricardo.PoCTaskManagement.domain.model.Task;

public interface CreateTaskUseCase {
	
	Task execute(Long projectId, String title, String description);
}