package com.ricardo.PoCTaskManagement.application.port.out;

import java.util.List;
import java.util.Optional;

import com.ricardo.PoCTaskManagement.domain.model.Task;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findByProjectId(Long projectId);
}
