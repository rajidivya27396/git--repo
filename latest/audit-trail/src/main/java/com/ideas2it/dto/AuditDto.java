package com.ideas2it.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ideas2it.entity.AuditTrailEntity;

import lombok.Data;

@Data
public class AuditDto {
	
	UUID transactionCode;
	String userCode;
	String entityName;
    long objectId;
    String methodName;
    String methodType;
    String api;
    LocalDateTime ChangedDate;
    
    public static AuditTrailEntity DtoToEntity(AuditDto dto) {
    	AuditTrailEntity entity = new AuditTrailEntity();
    	entity.setApi(dto.getApi());
    	entity.setChangedDate(dto.getChangedDate());
    	entity.setMethodType(dto.getMethodType());
    	entity.setMethodName(dto.getMethodName());
    	entity.setObjectId(dto.getObjectId());
    	entity.setUserCode(dto.getUserCode());
    	entity.setTransactionCode(dto.getTransactionCode());
    	entity.setEntityName(dto.getEntityName());
    	return entity;
    }
    
    public static AuditDto EntityToDto(AuditTrailEntity entity) {
    	AuditDto dto = new AuditDto();
    	dto.setApi(dto.getApi());
    	dto.setChangedDate(entity.getChangedDate());
    	dto.setMethodType(entity.getMethodType());
    	dto.setMethodName(entity.getMethodName());
    	dto.setObjectId(entity.getObjectId());
    	dto.setUserCode(entity.getUserCode());
    	dto.setTransactionCode(entity.getTransactionCode());
    	dto.setEntityName(entity.getEntityName());
    	return dto;
    }
	
}
