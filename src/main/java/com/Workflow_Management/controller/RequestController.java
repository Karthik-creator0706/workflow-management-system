package com.Workflow_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Workflow_Management.entity.Request;
import com.Workflow_Management.respository.*;

import java.time.LocalDateTime;
import com.Workflow_Management.entity.WorkflowLog;

@RestController
@RequestMapping("/requests")
@CrossOrigin("*")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;
    
    @Autowired
    private WorkflowLogRepository workflowLogRepository;

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        request.setStatus("SUBMITTED");
        return requestRepository.save(request);
    }

    @GetMapping
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

//    @PutMapping("/{id}/approve")
//    public Request approveRequest(@PathVariable Long id) {
//        Request request = requestRepository.findById(id).orElseThrow();
//        request.setStatus("APPROVED");
//        return requestRepository.save(request);
//    }
    @PutMapping("/{id}/approve")
    public Request approveRequest(@PathVariable Long id) {

        Request request = requestRepository.findById(id).orElseThrow();

        WorkflowLog log = new WorkflowLog();

        log.setRequestId(request.getId());
        log.setOldStatus(request.getStatus());
        log.setNewStatus("APPROVED");
        log.setChangedBy("MANAGER");
        log.setChangedDate(LocalDateTime.now());

        workflowLogRepository.save(log);

        request.setStatus("APPROVED");

        return requestRepository.save(request);
    }

//    @PutMapping("/{id}/reject")
//    public Request rejectRequest(@PathVariable Long id) {
//        Request request = requestRepository.findById(id).orElseThrow();
//        request.setStatus("REJECTED");
//        return requestRepository.save(request);
//    }
    @PutMapping("/{id}/reject")
    public Request rejectRequest(@PathVariable Long id) {

        Request request = requestRepository.findById(id).orElseThrow();

        WorkflowLog log = new WorkflowLog();

        log.setRequestId(request.getId());
        log.setOldStatus(request.getStatus());
        log.setNewStatus("REJECTED");
        log.setChangedBy("MANAGER");
        log.setChangedDate(LocalDateTime.now());

        workflowLogRepository.save(log);

        request.setStatus("REJECTED");

        return requestRepository.save(request);
    }
    
    @PutMapping("/{id}/clarify")
    public Request clarifyRequest(@PathVariable Long id) {

        Request request = requestRepository.findById(id).orElseThrow();

        WorkflowLog log = new WorkflowLog();

        log.setRequestId(request.getId());
        log.setOldStatus(request.getStatus());
        log.setNewStatus("NEEDS_CLARIFICATION");
        log.setChangedBy("MANAGER");
        log.setChangedDate(LocalDateTime.now());

        workflowLogRepository.save(log);

        request.setStatus("NEEDS_CLARIFICATION");

        return requestRepository.save(request);
    }
    
    @PutMapping("/{id}/close")
    public Request closeRequest(@PathVariable Long id) {

        Request request = requestRepository.findById(id).orElseThrow();

        WorkflowLog log = new WorkflowLog();

        log.setRequestId(request.getId());
        log.setOldStatus(request.getStatus());
        log.setNewStatus("CLOSED");
        log.setChangedBy("ADMIN");
        log.setChangedDate(LocalDateTime.now());

        workflowLogRepository.save(log);

        request.setStatus("CLOSED");

        return requestRepository.save(request);
    }
    
    @PutMapping("/{id}/reopen")
    public Request reopenRequest(@PathVariable Long id) {

        Request request = requestRepository.findById(id).orElseThrow();

        WorkflowLog log = new WorkflowLog();

        log.setRequestId(request.getId());
        log.setOldStatus(request.getStatus());
        log.setNewStatus("REOPENED");
        log.setChangedBy("ADMIN");
        log.setChangedDate(LocalDateTime.now());

        workflowLogRepository.save(log);

        request.setStatus("REOPENED");

        return requestRepository.save(request);
    }
}