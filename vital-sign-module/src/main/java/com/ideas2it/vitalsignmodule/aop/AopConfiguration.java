package com.ideas2it.vitalsignmodule.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfiguration {
	private static final Logger log=LoggerFactory.getLogger(AopConfiguration.class); 
	
	   @Around("@annotation(com.ideas2it.vitalsignmodule.aop.AopLogging)")
	   public Object logOutput(ProceedingJoinPoint p) throws Throwable {
	    	long startTime=System.currentTimeMillis();
	    	log.info("Execution started: class: "+p.getSignature()+" method: "+p.getTarget()+" args: "+p.getArgs());
	        Object object=p.proceed();
	    	long endTime=System.currentTimeMillis();
	    	log.info("Execution of method "+p.getTarget()+" completed in "+(endTime-startTime)+" ms");
	    	return object;
	   }
}
