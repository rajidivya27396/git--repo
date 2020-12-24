package com.ideas2it.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AuditDto {
	
	UUID transactionCode;
	String userCode;
	String entityName;
    long objectId;
    String methodName;
    String methodType;
    LocalDateTime ChangedDate;
	
}
