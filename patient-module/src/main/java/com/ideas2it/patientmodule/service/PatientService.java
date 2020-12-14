package com.ideas2it.patientmodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import com.ideas2it.patientmodule.dto.PatientDto;
import com.ideas2it.patientmodule.entity.Patient;

public interface PatientService {
	PatientDto savePatient(PatientDto patient);
    List<PatientDto> getPatients();
    void deletePatient(Optional<Long> id);
    PatientDto getPatientById(long id);
    PatientDto getPatientByName(String name);
    Page<Patient> getPager(PageRequest pageno);
    PatientDto updatePatient(PatientDto patient);

}
