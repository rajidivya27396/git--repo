package com.ideas2it.usermodule.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ideas2it.usermodule.aop.UserModuleAop;

@Aspect
@Component
public class UserModuleAop {
   private static final Logger log=LoggerFactory.getLogger(UserModuleAop.class); 
	
   @Around("@annotation(com.ideas2it.usermodule.aop.AopLogging)")
   public Object logOutput(ProceedingJoinPoint p) throws Throwable {
    	long startTime=System.currentTimeMillis();
    	log.info("Execution started: class: "+p.getSignature()+" method: "+p.getTarget()+" args: "+p.getArgs());
        Object object=p.proceed();
    	long endTime=System.currentTimeMillis();
    	log.info("Execution of method "+p.getTarget()+" completed in "+(endTime-startTime)+" ms");
    	return object;
   }
}
