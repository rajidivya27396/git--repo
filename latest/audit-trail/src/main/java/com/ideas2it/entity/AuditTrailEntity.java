package com.ideas2it.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Audit_Trail")
public class AuditTrailEntity {
	
	@Id
	UUID transactionCode;
	String userCode;
	String entityName;
    long objectId;
    String methodName;
    String methodType;
    String api;
    LocalDateTime ChangedDate;
	
}
