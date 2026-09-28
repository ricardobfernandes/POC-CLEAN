package com.ricardo.PoCTaskManagement.adapter.in.web.dto;

import com.ricardo.PoCTaskManagement.domain.model.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record ChangeTaskStatusRequest(@NotNull TaskStatus status) {

}