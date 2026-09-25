package com.ricardo.PoCTaskManagement.application.port.in;

import com.ricardo.PoCTaskManagement.domain.model.Task;
import com.ricardo.PoCTaskManagement.domain.model.TaskStatus;

public interface ChangeTaskStatusUseCase {
	
	Task execute(Long taskId, TaskStatus status);
}