package edu.esprit.interceptor;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitoringAspect {

	private Long duration;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PerformanceMonitoringAspect.class);

	@Before("execution(* edu.esprit.service.*.*(..))")
	public void start(JoinPoint joinPoint) {

		duration = new Date().getTime();

	}

	@After("execution(* edu.esprit.service.*.*(..))")
	public void end(JoinPoint joinPoint) {

		duration = Math.abs((duration -= new Date().getTime()));
		LOGGER.debug("[PERFORMANCE MONITOR] execution of [" + joinPoint.getSignature().getName() + "] in " + duration + " millis.\n");
	}
}
