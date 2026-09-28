package com.ricardo.PoCTaskManagement.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AssignTaskRequest(@NotNull @Positive Long userId) {

}