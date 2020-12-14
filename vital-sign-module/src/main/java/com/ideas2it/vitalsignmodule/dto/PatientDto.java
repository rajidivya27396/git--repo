package com.ideas2it.vitalsignmodule.dto;

import java.io.Serializable;
import java.util.Date;

import com.ideas2it.vitalsignmodule.entity.Address;

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
	  
	 
}
