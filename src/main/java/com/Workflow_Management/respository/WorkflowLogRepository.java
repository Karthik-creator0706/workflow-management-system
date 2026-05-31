//package com.Workflow_Management.respository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.Workflow_Management.entity.WorkflowLog;
//
//public interface WorkflowLogRepository extends JpaRepository<WorkflowLog, Long> {
//
//}

package com.Workflow_Management.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Workflow_Management.entity.WorkflowLog;

public interface WorkflowLogRepository
        extends JpaRepository<WorkflowLog, Long> {
}