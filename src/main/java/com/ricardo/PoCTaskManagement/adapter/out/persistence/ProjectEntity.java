package com.ricardo.PoCTaskManagement.adapter.out.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	protected ProjectEntity() {
	}

	public ProjectEntity(Long id, String name) {
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