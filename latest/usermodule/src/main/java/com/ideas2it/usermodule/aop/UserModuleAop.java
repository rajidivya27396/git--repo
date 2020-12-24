package com.ideas2it.usermodule.aop;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.usermodule.dto.AuditDto;
import com.ideas2it.usermodule.dto.UserDto;

@Aspect
@Component
public class UserModuleAop {
   private static final Logger log=LoggerFactory.getLogger(UserModuleAop.class); 
   @Autowired
   private KafkaTemplate<String,Object> template;
   private String TOPIC = "topic8";
   
   @Around("@annotation(com.ideas2it.usermodule.aop.AopLogging)")
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
     	UserDto user = (UserDto) object;
   	    dto.setTransactionCode(UUID.randomUUID());
   	    dto.setEntityName(auditInfo[0]);
   	    dto.setMethodName(auditInfo[1]);
   	    dto.setChangedDate(user.getUpdatedDate());
   	    dto.setObjectId(user.getId());
   	    dto.setUserCode(user.getUpdatedUser());
   	    template.send(TOPIC, dto);
   }
}
