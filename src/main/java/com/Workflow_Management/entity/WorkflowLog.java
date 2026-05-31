//package com.Workflow_Management.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="workflow_logs")
//public class WorkflowLog {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String oldStatus;
//
//    private String newStatus;
//
//    private String changedBy;
//
//    public WorkflowLog() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getOldStatus() {
//        return oldStatus;
//    }
//
//    public void setOldStatus(String oldStatus) {
//        this.oldStatus = oldStatus;
//    }
//
//    public String getNewStatus() {
//        return newStatus;
//    }
//
//    public void setNewStatus(String newStatus) {
//        this.newStatus = newStatus;
//    }
//
//    public String getChangedBy() {
//        return changedBy;
//    }
//
//    public void setChangedBy(String changedBy) {
//        this.changedBy = changedBy;
//    }

package com.Workflow_Management.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="workflow_logs")
public class WorkflowLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

	public String getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public LocalDateTime getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(LocalDateTime changedDate) {
		this.changedDate = changedDate;
	}

	private Long requestId;

    private String oldStatus;

    private String newStatus;

    private String changedBy;

    private LocalDateTime changedDate;

    // Getters and Setters
}
//}