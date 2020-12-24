package com.ideas2it.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.ideas2it.entity.VitalSign;

import lombok.Data;

@Data
public class VitalSignDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7376210113657200403L;
	private long vital_pk;
	private long patient_fk;
	private int pulseRate;
	private int bloodPressure;
	private int temperature;
	private int height;
    private int weight;
	private String bloodGroup;
	private int respirationRate;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdUser;
    private String updatedUser;
    public static VitalSignDto entityToDto(VitalSign entity)
    {
    	VitalSignDto dto=new VitalSignDto();
    	dto.setVital_pk(entity.getVital_pk());
	    dto.setPatient_fk(entity.getPatient_fk());
	    dto.setHeight(entity.getHeight());
	    dto.setPulseRate(entity.getPulseRate());
	    dto.setTemperature(entity.getTemperature());
	    dto.setWeight(entity.getWeight());
	    dto.setCreatedUser(entity.getCreatedUser());
	    dto.setUpdatedUser(entity.getUpdatedUser());
	    dto.setCreatedDate(entity.getCreatedDate());
	    dto.setUpdatedDate(entity.getUpdatedDate());
    	return dto;
    }
    public static VitalSign dtoToEntity(VitalSignDto dto)
    {   
    	VitalSign entity=new VitalSign();
    	entity.setPatient_fk(dto.getPatient_fk());
    	entity.setHeight(dto.getHeight());
    	entity.setPulseRate(dto.getPulseRate());
    	entity.setTemperature(dto.getTemperature());
    	entity.setWeight(dto.getWeight());
    	entity.setCreatedUser(dto.getCreatedUser());
    	entity.setUpdatedUser(dto.getUpdatedUser());
    	entity.setCreatedDate(dto.getCreatedDate());
    	entity.setUpdatedDate(dto.getUpdatedDate());
    	return entity;
    	
    }

}
