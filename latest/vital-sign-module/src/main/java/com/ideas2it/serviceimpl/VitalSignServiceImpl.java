package com.ideas2it.serviceimpl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.aop.AopLogging;
import com.ideas2it.dto.VitalSignDto;
import com.ideas2it.entity.ReportClass;
import com.ideas2it.entity.VitalSign;
import com.ideas2it.repository.ReportRepository;
import com.ideas2it.repository.VitalSignRepository;
import com.ideas2it.service.VitalSignService;
/**
 * Implementing CRUD operations for vitalmodule
 *
 * @author Rajalakshmi
 */
@Service
public class VitalSignServiceImpl implements VitalSignService {
	
	private VitalSignRepository vitalRepo;
	private ReportRepository report;
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	public VitalSignServiceImpl(VitalSignRepository vitalRepo,ReportRepository report) {
		this.vitalRepo = vitalRepo;
		this.report = report;
	}
	
    /**
     * Saving vital information in patient and report table
     */
	@Override
	@AopLogging
	public VitalSignDto saveVitalSign(VitalSignDto vitalsign, long id) {
		
		//where p.patient_fk = ?1
		//.setParameter(1, vitalsign.getPatient_fk())
		VitalSignDto info =VitalSignDto.entityToDto(manager.createQuery("select p from VitalSign p where p.patient_fk=?1 order by p.updatedDate DESC ",VitalSign.class).setParameter(1, id).getResultList().get(0));
		VitalSignDto vitalDto=VitalSignDto.entityToDto(vitalRepo.save(VitalSignDto.dtoToEntity(vitalsign)));
		vitalsign.setPatient_fk(id);
		if(info!=null)
		  report.save(createReport(vitalDto,info));
		else
		  report.save(new ReportClass(id));	
		  
		return vitalDto;
	}

	@Override
	public VitalSignDto getVitalSign(long id) {
	    return VitalSignDto.entityToDto(vitalRepo.findByPatientID(id));
    }
	
	public ReportClass createReport(VitalSignDto vitalsign,VitalSignDto info) {
		ReportClass reportClass = new ReportClass();
		int diff=0;
		reportClass.setPatient_fk(vitalsign.getPatient_fk());
		diff = info.getBloodPressure()-vitalsign.getBloodPressure();
		reportClass.setBPDiff(Math.abs(diff));
		reportClass.setBPSign(calculateDiff(diff));
		diff = info.getRespirationRate()-vitalsign.getRespirationRate();
		reportClass.setRespdiff(Math.abs(diff));
		reportClass.setRespSign(calculateDiff(diff));
		diff = info.getPulseRate()-vitalsign.getBloodPressure();
		reportClass.setPRDiff(Math.abs(diff));
		reportClass.setPRSign(calculateDiff(diff));
		diff = info.getTemperature()-vitalsign.getTemperature();
		reportClass.setTempdiff(Math.abs(diff));
		reportClass.setTempSign(calculateDiff(diff));
		reportClass.setNextCheckupDate(vitalsign.getUpdatedDate().plusDays(5));
		diff = info.getWeight()-vitalsign.getWeight();
		reportClass.setWeightdiff(Math.abs(diff));
		reportClass.setWeightSign(calculateDiff(diff));
		return reportClass;
	}
	
	private String calculateDiff(int diff) {
		return (diff < 0) ? String.format("DEC by %s",diff):String.format("INC by %s",diff);
	}
	
	/** 
	 *Generate Report for a particular patient
	 *
	 *@param id
	 */
	@Override
	public Optional<ReportClass> getReport(long id) {
		return report.findById(id);
	}
}
