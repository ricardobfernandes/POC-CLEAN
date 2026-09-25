package com.ricardo.PoCTaskManagement.application.port.in;

import java.util.List;
import com.ricardo.PoCTaskManagement.domain.model.Task;

public interface FindProjectTasksUseCase {
	
	List<Task> execute(Long projectId);
}