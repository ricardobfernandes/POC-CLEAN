package com.ricardo.PoCTaskManagement.adapter.in.web.exception;

import java.time.Instant;

public record StandardError(Instant timestamp, Integer status, String error, String message) {
}