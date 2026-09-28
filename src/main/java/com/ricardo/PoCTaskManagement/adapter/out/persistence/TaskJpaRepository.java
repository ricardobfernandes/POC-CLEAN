package com.ricardo.PoCTaskManagement.adapter.out.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {

	List<TaskEntity> findByProjectId(Long projectId);
}