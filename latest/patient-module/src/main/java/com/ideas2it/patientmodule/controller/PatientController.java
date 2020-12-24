package com.ideas2it.patientmodule.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.patientmodule.dto.PatientDto;
import com.ideas2it.patientmodule.entity.Patient;
import com.ideas2it.patientmodule.serviceimpl.PatientServiceImpl;
/**
 * Implementing controller for patientmodule
 *
 * @author Rajalakshmi
 */
@RestController
@RequestMapping("patients")
public class PatientController 
{
	    private PatientServiceImpl service;
	    
	    @Autowired
	    public PatientController(PatientServiceImpl service) {
	        this.service=service;
	    }
	    
	    @PostMapping("/register")
	    public PatientDto registerPatient(@RequestBody PatientDto patient) {
	        return service.savePatient(patient);
	    }
	    
	    @PutMapping("/update")
	    @CachePut(cacheNames={"patientcache"},key="#patient.patient_id")
	    public PatientDto updatePatient(@RequestBody PatientDto patient) {
	        return service.updatePatient(patient);
	    }
	    
	    @DeleteMapping("/remove/{id}")
	    @CacheEvict(cacheNames={"patientcache"},key="#id")
	    public void removePatient(@PathVariable("id") Optional<Long> id) {
	        service.deletePatient(id);
	    }
	    
	    @GetMapping("/show")
	    public Page<Patient> showPage(@RequestParam("page") Optional<Integer> pageno) {
	    	int page=pageno.orElse(0);
	        return service.getPager(PageRequest.of(page,5));
	    }
	    
	    @GetMapping("/name")
	    public PatientDto searchByName(@RequestParam("name") String name) {
	        return service.getPatientByName(name);
	    }
	    
	    @GetMapping("/id")
	    @Cacheable(cacheNames={"patientcache"},key="#id")
	    public PatientDto searchById(@RequestParam("id") long id) {
	        return service.getPatientById(id);
	    }
	    	    
}
