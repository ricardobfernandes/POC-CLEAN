package com.ricardo.PoCTaskManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ricardo.PoCTaskManagement.application.port.in.*;
import com.ricardo.PoCTaskManagement.application.port.out.*;
import com.ricardo.PoCTaskManagement.application.service.*;

@Configuration
public class BeanConfig {

	@Bean
	public CreateProjectUseCase createProjectUseCase(ProjectRepository repository) {
		return new CreateProjectService(repository);
	}

	@Bean
	public CreateUserUseCase createUserUseCase(UserRepository repository) {
		return new CreateUserService(repository);
	}

	@Bean
	public CreateTaskUseCase createTaskUseCase(ProjectRepository projectRepository, TaskRepository taskRepository) {
		return new CreateTaskService(projectRepository, taskRepository);
	}

	@Bean
	public AssignTaskUseCase assignTaskUseCase(TaskRepository taskRepository, UserRepository userRepository) {
		return new AssignTaskService(taskRepository, userRepository);
	}

	@Bean
	public ChangeTaskStatusUseCase changeTaskStatusUseCase(TaskRepository taskRepository) {
		return new ChangeTaskStatusService(taskRepository);
	}

	@Bean
	public FindProjectTasksUseCase findProjectTasksUseCase(ProjectRepository projectRepository,
			TaskRepository taskRepository) {
		return new FindProjectTasksService(projectRepository, taskRepository);
	}
}