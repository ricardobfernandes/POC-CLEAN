package com.ricardo.PoCTaskManagement.domain.model;

import com.ricardo.PoCTaskManagement.domain.exception.InvalidProjectInfoException;

public class Project {

	private Long id;
	private String name;

	public Project(Long id, String name) {
		if (name == null || name.isBlank()) {
			throw new InvalidProjectInfoException("Project name is required");
		}
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
