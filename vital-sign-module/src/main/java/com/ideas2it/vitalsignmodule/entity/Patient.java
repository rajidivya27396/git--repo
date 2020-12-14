package com.ideas2it.vitalsignmodule.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Patient Entity
 *
 * @author Rajalakshmi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends AuditClass implements Serializable {
 
  private static final long serialVersionUID = -5132680945972698473L;

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  @Column(name="patientid")
  private long patientId;
  
  @Column(name="firstname")
  private String firstname;
  
  @Column(name="lastname")
  private String lastname;
  
  @Column(name="gender")
  private String gender;
  
  @Column(name="age")
  private int age;
  
  @Column(name="insuranceholder")
  private boolean insuranceHolder;
  
  @Column(name="lastvisiteddate")
  private Date lastVisitedDate;
  
  @Column(name="mobileno")
  private String mobileno;
  
  @Column(name="guardian")
  private String guardian;
  
  @Column(name="guardian_mobileno")
  private String guardian_mobileno;
  
  @Column(name="relationship")
  private String relationship;
  
  @Column(name="referringdoctor")
  private String referringDoctor;
  
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="address")
  private Address address;
  
}
