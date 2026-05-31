package com.Workflow_Management.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Workflow_Management.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}