package com.ideas2it.vitalsignmodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.vitalsignmodule.dto.PatientDto;
import com.ideas2it.vitalsignmodule.dto.VitalSignDto;
import com.ideas2it.vitalsignmodule.entity.VitalSign;
import com.ideas2it.vitalsignmodule.feign.Client;
import com.ideas2it.vitalsignmodule.service.VitalSignService;

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

}
