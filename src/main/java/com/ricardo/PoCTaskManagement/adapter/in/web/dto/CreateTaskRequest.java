package com.ricardo.PoCTaskManagement.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequest(@NotBlank String title, String description) {

}