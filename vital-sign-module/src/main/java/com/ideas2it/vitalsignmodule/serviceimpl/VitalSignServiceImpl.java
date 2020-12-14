package com.ideas2it.vitalsignmodule.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.vitalsignmodule.dto.VitalSignDto;
import com.ideas2it.vitalsignmodule.entity.ReportClass;
import com.ideas2it.vitalsignmodule.entity.VitalSign;
import com.ideas2it.vitalsignmodule.repository.ReportRepository;
import com.ideas2it.vitalsignmodule.repository.VitalSignRepository;
import com.ideas2it.vitalsignmodule.service.VitalSignService;
/**
 * Implementing CRUD operations for vitalmodule
 *
 * @author Rajalakshmi
 */
@Service
public class VitalSignServiceImpl implements VitalSignService{
	
	private VitalSignRepository vitalRepo;
	private ReportRepository report;
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	public VitalSignServiceImpl(VitalSignRepository vitalRepo,ReportRepository report) {
		this.vitalRepo = vitalRepo;
		this.report = report;
	}

	@Override
	public VitalSignDto saveVitalSign(VitalSignDto vitalsign, long id) {
		vitalsign.setPatient_fk(id);
		//where p.patient_fk = ?1
		//.setParameter(1, vitalsign.getPatient_fk())
		
		VitalSignDto info =VitalSignDto.entityToDto(manager.createQuery("select p from VitalSign p where p.patient_fk=?1 order by p.updatedDate DESC ",VitalSign.class).setParameter(1, id).getResultList().get(0));
		VitalSignDto vitalDto=VitalSignDto.entityToDto(vitalRepo.save(VitalSignDto.dtoToEntity(vitalsign)));
		if(info!=null)
		  report.save(createReport(vitalDto,info));
		else
		  report.save(new ReportClass(id));	
		  
		return vitalDto;
	}

	@Override
	public VitalSignDto getVitalSign(long id) {
	    return VitalSignDto.entityToDto(vitalRepo.findByPatientID(id));
		//return new VitalSignDto();
	}
	
	public ReportClass createReport(VitalSignDto vitalsign,VitalSignDto info)
	{
		ReportClass reportClass = new ReportClass();
		reportClass.setPatient_fk(vitalsign.getPatient_fk());
		reportClass.setBPDiff(info.getBloodPressure()-vitalsign.getBloodPressure());
		reportClass.setBPSign("N");
		reportClass.setRespdiff(info.getRespirationRate()-vitalsign.getRespirationRate());
		reportClass.setRespSign("N");
		reportClass.setPRDiff(info.getPulseRate()-vitalsign.getPulseRate());
		reportClass.setPRSign("N");
		reportClass.setTempdiff(info.getTemperature()-vitalsign.getTemperature());
		reportClass.setTempSign("N");
		reportClass.setNextCheckupDate(vitalsign.getUpdatedDate().plusDays(5));
		reportClass.setWeightdiff(info.getWeight()-vitalsign.getWeight());
		reportClass.setWeightSign("N");
		return reportClass;
	}
}
