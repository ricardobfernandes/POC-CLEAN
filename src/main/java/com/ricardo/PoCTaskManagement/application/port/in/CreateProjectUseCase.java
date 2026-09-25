package com.ricardo.PoCTaskManagement.application.port.in;

import com.ricardo.PoCTaskManagement.domain.model.Project;

public interface CreateProjectUseCase {

	Project execute(String name);
}
