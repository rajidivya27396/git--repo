package com.ideas2it.patientmodule.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ideas2it.patientmodule.aop.AopLogging;
import com.ideas2it.patientmodule.dto.PatientDto;
import com.ideas2it.patientmodule.entity.Patient;
import com.ideas2it.patientmodule.repository.PatientRepository;
import com.ideas2it.patientmodule.service.PatientService;
/**
 * Implementing CRUD operations for patientmodule
 *
 * @author Rajalakshmi
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepo;   
    
    @Autowired
    public PatientServiceImpl(PatientRepository patientRepo) {
        this.patientRepo=patientRepo;
    }
    
	@Override
	@AopLogging
	public PatientDto savePatient(PatientDto patient) {
	   return PatientDto.entityToDto(patientRepo.save(PatientDto.dtoToEntity(patient)));
	}

	@Override
	@AopLogging
	public List<PatientDto> getPatients() {
        return PatientDto.entityToDto(patientRepo.findAll());
	}

	@Override
	public void deletePatient(Optional<Long> id) {
	    patientRepo.deleteById(id.get());
	  //  return new ResponseEntity<>("Patient is deleted successfully",HttpStatus.OK);
	}

	@Override
	public Page<Patient> getPager(PageRequest pageno) {
		return patientRepo.findAll(pageno);
	}

	@Override
	@AopLogging
	public PatientDto updatePatient(PatientDto patient) {
		return PatientDto.entityToDto(patientRepo.save(PatientDto.dtoToEntity(patient)));
	}
	
	@Override
	@AopLogging
	public PatientDto getPatientByName(String name) {
		return PatientDto.entityToDto(patientRepo.findByPatientname(name));
	}
	
	@Override
	@AopLogging
	public PatientDto getPatientById(long id) {
	    return PatientDto.entityToDto(patientRepo.findByPatientId(id));
	}
	
}
