package com.ideas2it.patientmodule.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ideas2it.patientmodule.entity.Address;
import com.ideas2it.patientmodule.entity.Patient;

import lombok.Data;

@Data
public class PatientDto implements Serializable 
{
      private static final long serialVersionUID = 1979603375923889506L;
	  private long patientId;
      private String firstname;
      private String lastname;
      private String gender;
	  private int age;
	  private boolean insuranceHolder;
	  private Date lastVisitedDate;
	  private String mobileno;
	  private String guardian;
	  private String guardian_mobileno;
	  private String relationship;
	  private String referringDoctor;
	  private Address address;
	  private LocalDateTime createdDate;
	  private LocalDateTime updatedDate;
	  private String createdUser;
	  private String updatedUser;
	  
	  public static Patient dtoToEntity(PatientDto dto) {
		    Patient entity=new Patient();
		    entity.setPatientId(dto.getPatientId());
	        entity.setFirstname(dto.getFirstname());
	        entity.setLastname(dto.getLastname());
	        entity.setGender(dto.getGender());
	        entity.setGuardian(dto.getGuardian());
	        entity.setGuardian_mobileno(dto.getGuardian_mobileno());
	        entity.setAge(dto.getAge());
	        entity.setMobileno(dto.getMobileno());
	        entity.setLastVisitedDate(dto.getLastVisitedDate());
	        entity.setReferringDoctor(dto.getReferringDoctor());
	        entity.setRelationship(dto.getRelationship());
	        entity.setAddress(dto.getAddress());
	        entity.setCreatedDate(dto.getCreatedDate());
	        entity.setCreatedUser(dto.getCreatedUser());
	        entity.setUpdatedDate(dto.getUpdatedDate());
	        entity.setUpdatedUser(dto.getUpdatedUser());
	        return entity;
	  }
	  
	  public static PatientDto entityToDto(Patient entity) {
		    PatientDto dto=new PatientDto();
		    dto.setPatientId(entity.getPatientId());
		    dto.setFirstname(entity.getFirstname());
		    dto.setLastname(entity.getLastname());
		    dto.setGender(entity.getGender());
		    dto.setGuardian(entity.getGuardian());
		    dto.setGuardian_mobileno(entity.getGuardian_mobileno());
	        dto.setAge(entity.getAge());
	        dto.setMobileno(entity.getMobileno());
	        dto.setLastVisitedDate(entity.getLastVisitedDate());
	        dto.setReferringDoctor(entity.getReferringDoctor());
	        dto.setRelationship(entity.getRelationship());
	        dto.setAddress(entity.getAddress());
	        dto.setCreatedDate(entity.getCreatedDate());
	        dto.setCreatedUser(entity.getCreatedUser());
	        dto.setUpdatedDate(entity.getUpdatedDate());
	        dto.setUpdatedUser(entity.getUpdatedUser());
	        return dto;
	  }
	  
	  public static List<PatientDto> entityToDto(List<Patient> entity) {
		    List<PatientDto> dto= new ArrayList<>();
		    for(int i=0;i<entity.size();i++)
		      dto.add(PatientDto.entityToDto(entity.get(i)));
		    return dto;
	  }
}
