package com.ideas2it.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ideas2it.dto.AuditDto;
import com.ideas2it.entity.AuditTrailEntity;
import com.ideas2it.repository.AuditRepository;

@Service
public class AuditServiceImpl {
	
	private AuditRepository auditRepo;
	private MongoTemplate mongoTemplate;
	@Autowired
	public AuditServiceImpl(AuditRepository auditRepo) {
		this.auditRepo = auditRepo;
	}
	
	public List<AuditTrailEntity> getAuditEvents() {
		return auditRepo.findAll();
	}

	
	public List<AuditTrailEntity> getFilteredRecords(String api) {
		Query query = new Query();
		query.addCriteria(new Criteria().where("api").is(api));
		return mongoTemplate.find(query, AuditTrailEntity.class);
		
	}
	
	@KafkaListener(groupId="group-1" ,topics = "topic6", containerFactory = "vitalKafkaListenerContainerFactory")
	public void getVitalAuditLogs(AuditDto dto) {
        dto.setApi("Vital API");
        auditRepo.save(AuditDto.DtoToEntity(dto));
	}
	
	@KafkaListener(groupId="group-2" ,topics = "topic7", containerFactory = "patientKafkaListenerContainerFactory")
	public void getPatientAuditLog(AuditDto dto) {
        dto.setApi("Patient API");
        auditRepo.save(AuditDto.DtoToEntity(dto));
    }
	
	@KafkaListener(groupId="group-3" ,topics = "topic8", containerFactory = "userKafkaListenerContainerFactory")
	public void UserAuditLog(AuditDto dto) {
	    dto.setApi("User API");
	    auditRepo.save(AuditDto.DtoToEntity(dto));
    }

}
