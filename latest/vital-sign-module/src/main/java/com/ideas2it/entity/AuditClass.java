package com.ideas2it.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class AuditClass {

	@Column(name="CreatedDate",updatable=false)
	@CreatedDate
	private LocalDateTime createdDate;
	
	@Column(name="UpdatedDate")
	@LastModifiedDate
	private LocalDateTime updatedDate;
	
	@Column(name="CreatedUser",updatable=false)
	@CreatedBy
	private String createdUser;
	
	@Column(name="UpdatedUser")
	@LastModifiedBy
	private String updatedUser;
}
