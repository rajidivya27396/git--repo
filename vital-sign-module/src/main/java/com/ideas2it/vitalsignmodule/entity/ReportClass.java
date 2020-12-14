package com.ideas2it.vitalsignmodule.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="Report")
public class ReportClass implements Serializable {

	private static final long serialVersionUID = 2120621580727577213L;
    @Id
    long id1;
	long patient_fk;
	long user_fk;
    private int pRDiff;
    private String pRSign;
	private String pulseSign;
	private int bPDiff;
	private String bPSign;
	private int tempdiff;
	private String tempSign;
	private int weightdiff;
	private String weightSign;
    private int respdiff;
    private String respSign;
    LocalDateTime lastVisitedDate;
    LocalDateTime nextCheckupDate;
    public ReportClass(long patient_fk) {
    	this.patient_fk=patient_fk;
    }
}
