package com.ideas2it.aop;
import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ideas2it.dto.AuditDto;
import com.ideas2it.dto.VitalSignDto;

@Aspect
@Component
public class AopConfiguration {
	private static final Logger log=LoggerFactory.getLogger(AopConfiguration.class); 
	@Autowired
	  private KafkaTemplate<String,Object> template;
	  private String topic = "topic6";

	   @Around("@annotation(com.ideas2it.aop.AopLogging)")
	   public Object logOutput(ProceedingJoinPoint p) throws Throwable {
	    	long startTime=System.currentTimeMillis();
	    	log.info("Execution started: class: "+p.getSignature()+" method: "+p.getTarget()+" args: "+p.getArgs());
	        Object object=p.proceed();
	    	long endTime=System.currentTimeMillis();
	    	log.info("Execution of method "+p.getTarget()+" completed in "+(endTime-startTime)+" ms");
	    	auditLog(p,object);
	    	return object;
	   }
	   
	   public void auditLog(ProceedingJoinPoint p,Object object) throws Throwable {
		    String auditInfo[] = p.getSignature().toString().split(" ");
	        AuditDto dto = new AuditDto();
	        VitalSignDto vitalSign = (VitalSignDto) object;
	    	dto.setTransactionCode(UUID.randomUUID());
	    	dto.setEntityName(auditInfo[0]);
	    	dto.setMethodName(auditInfo[1]);
	    	dto.setObjectId(vitalSign.getVital_pk());
	    	dto.setChangedDate(vitalSign.getUpdatedDate());
	    	dto.setUserCode(vitalSign.getUpdatedUser());
	    	template.send(topic, dto);
	   }
}
