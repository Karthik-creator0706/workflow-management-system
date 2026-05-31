package com.Workflow_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Workflow_Management.entity.WorkflowLog;
import com.Workflow_Management.respository.*;

@RestController
@RequestMapping("/logs")
@CrossOrigin("*")
public class WorkflowLogController {

    @Autowired
    private WorkflowLogRepository repository;

    @GetMapping
    public List<WorkflowLog> getAllLogs() {
        return repository.findAll();
    }
}