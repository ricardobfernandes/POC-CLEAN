package com.ricardo.PoCTaskManagement.domain.model;

import com.ricardo.PoCTaskManagement.domain.exception.InvalidTaskStatusException;

public enum TaskStatus {
    TODO(1),
    IN_PROGRESS(2),
    DONE(3);

	private int code;

	private TaskStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TaskStatus valueOf(int code) {
		for (TaskStatus value : TaskStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new InvalidTaskStatusException("Invalid task status code");
	}
}