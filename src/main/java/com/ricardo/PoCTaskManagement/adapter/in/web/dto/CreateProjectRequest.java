package com.ricardo.PoCTaskManagement.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequest(@NotBlank String name) {

}