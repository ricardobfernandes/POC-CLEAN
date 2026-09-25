package com.ricardo.PoCTaskManagement.application.port.in;

import com.ricardo.PoCTaskManagement.domain.model.Task;

public interface AssignTaskUseCase {
	
	Task execute(Long taskId, Long userId);
}