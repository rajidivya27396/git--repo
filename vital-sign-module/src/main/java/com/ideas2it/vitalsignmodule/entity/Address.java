package com.ideas2it.vitalsignmodule.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AuditClass implements Serializable 
{
  private static final long serialVersionUID = 8134122164980814319L;
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  @Column(name="address_pk")
  private Long address_pk;
  @Column(name="addressline1")
  private String addressLine1;
  @Column(name="addressline2")
  private String addressLine2;
  @Column(name="district")
  private String district;
  @Column(name="country")
  private String country;
  @Column(name="state")
  private String state;
  @Column(name="pincode")
  private String pincode;
  @OneToOne(mappedBy="address")
  private Patient patient;
  }
