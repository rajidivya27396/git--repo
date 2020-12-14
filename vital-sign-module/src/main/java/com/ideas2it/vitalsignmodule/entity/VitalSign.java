package com.ideas2it.vitalsignmodule.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vitalsign")
@Data
public class VitalSign extends AuditClass implements Serializable {

	private static final long serialVersionUID = -7482765404240005892L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="vital_pk")
    private long vital_pk;
	@Column(name="patient_fk")
	private long patient_fk;
	@Column(name="pulse_rate")
    private int pulseRate;
	@Column(name="blood_pressure")
    private int bloodPressure;
	@Column(name="temperature")
    private int temperature;
	@Column(name="height")
    private int height;
	@Column(name="weight")
	private int weight;
	@Column(name="blood_group")
    private String bloodGroup;
	@Column(name="respiration_rate")
    private int respirationRate;
    	
}
