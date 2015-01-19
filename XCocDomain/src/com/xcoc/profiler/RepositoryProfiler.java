package com.xcoc.profiler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class RepositoryProfiler {

	private static final Log logger = LogFactory.getLog(RepositoryProfiler.class);
	//private static final Logger logger = Logger.getLogger(RepositoryProfiler.class);
	
	
	@Around("execution(* com.xcoc..*.*Repository.*(..))")
	public Object executionTime (ProceedingJoinPoint joinPoint) 
													throws Throwable {
		
		Object processResult = null;
		
		long start = System.currentTimeMillis();

		processResult = joinPoint.proceed(joinPoint.getArgs());
		
		long end = System.currentTimeMillis();
		
		logger.info( joinPoint.getClass().getName() 
						+ "." 
						+  joinPoint.getTarget() 
						+ " : " + ( end - start ) + " ms ");	
		
		return processResult;
	}
	
	
}
