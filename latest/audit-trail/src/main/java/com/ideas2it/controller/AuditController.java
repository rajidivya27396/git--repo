package com.ideas2it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.dto.AuditDto;
import com.ideas2it.dto.VitalDto;
import com.ideas2it.entity.AuditTrailEntity;
import com.ideas2it.repository.AuditRepository;
import com.ideas2it.serviceimpl.AuditServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("auditEvents")
public class AuditController {

	private AuditServiceImpl service;
	@Autowired
	public AuditController(AuditServiceImpl service) {
		this.service = service;
	}
	
    @GetMapping("/show")
	public List<AuditTrailEntity> showEvents() {
		return service.getAuditEvents();
	}
    
    @GetMapping("/filter")
  	public List<AuditTrailEntity> showEvents(@RequestParam("api") String api) {
  		return service.getFilteredRecords(api);
  	}
}