package com.ideas2it.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.dto.PatientDto;
import com.ideas2it.dto.VitalSignDto;
import com.ideas2it.entity.ReportClass;
import com.ideas2it.entity.VitalSign;
import com.ideas2it.feign.Client;
import com.ideas2it.service.VitalSignService;

@RestController
@RequestMapping("vitalsign")
public class VitalSignController {

	private VitalSignService service;
	private Client client;
	
	@Autowired
	public VitalSignController(Client client,VitalSignService service) {
		this.service=service;
		this.client=client;
	}
	
	@PostMapping("/")
	public VitalSignDto add(@RequestBody VitalSignDto vitalsign) {
		//PatientDto patient=client.searchById(90);
		//patient.getPatientId()
		return service.saveVitalSign(vitalsign,8);
	}

	@GetMapping("/")
	public VitalSignDto get(@RequestParam("patientid") long patientid) {
		return service.getVitalSign(patientid);
	}
	
	@GetMapping("/report")
	public Optional<ReportClass> generateReport(@RequestParam("patientid") long patientid) {
		return service.getReport(patientid);
	}

}
