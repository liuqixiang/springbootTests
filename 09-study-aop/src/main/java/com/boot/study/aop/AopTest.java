package com.boot.study.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Aspect
public class AopTest {

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void aspect() {

	}

	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint);
	}

	@Around("aspect()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println(joinPoint);
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		GetMapping getMapping = methodSignature.getMethod().getAnnotation(GetMapping.class);
		String[] strings = getMapping.value();
		System.out.println(Arrays.toString(strings));

		Object[] objects = joinPoint.getArgs();
		System.out.println(Arrays.toString(objects));

		return joinPoint.proceed();
	}

}
