package com.ideas2it.patientmodule.aop;
import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.patientmodule.dto.AuditDto;
import com.ideas2it.patientmodule.dto.PatientDto;
/**
 * aop configuration
 *
 * @author Rajalakshmi
 */
@Aspect
@Component
public class AopConfiguration {
	   private static final Logger log=LoggerFactory.getLogger(AopConfiguration.class); 
	   @Autowired
	   private KafkaTemplate<String,Object> template;
	   private String TOPIC = "topic7";
	   @Around("@annotation(com.ideas2it.patientmodule.aop.AopLogging)")
	   public Object logOutput(ProceedingJoinPoint p) throws Throwable {
	        long startTime=System.currentTimeMillis();
	    	log.info("Execution started: class: "+p.getSignature()+" method: "+p.getTarget()+" args: "+p.getArgs());
	        Object object=p.proceed();
	        long endTime=System.currentTimeMillis();
	    	log.info("Execution of method: "+p.getTarget()+" completed in "+(endTime-startTime)+" ms");
	      	auditLog(p,object);
            return object;
	   }
	   public void auditLog(ProceedingJoinPoint p,Object object) throws Throwable {
		    String auditInfo[] = p.getSignature().toString().split(" ");
	        AuditDto dto = new AuditDto();
	        PatientDto patient = (PatientDto) object;
	    	dto.setTransactionCode(UUID.randomUUID());
	    	dto.setEntityName(auditInfo[0]);
	    	dto.setMethodName(auditInfo[1]);
	    	dto.setObjectId(patient.getPatientId());
	    	dto.setChangedDate(patient.getUpdatedDate());
	    	dto.setUserCode(patient.getUpdatedUser());
	    	template.send(TOPIC, dto);
	   }
}
