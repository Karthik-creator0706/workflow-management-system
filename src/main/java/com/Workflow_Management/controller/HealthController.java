package com.Workflow_Management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Workflow Management System Running";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}