package com.ricardo.PoCTaskManagement.application.port.out;

import com.ricardo.PoCTaskManagement.domain.model.Project;

public interface ProjectRepository {

	Project save(Project project);

	boolean existsById(Long id);

}