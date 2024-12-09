package com.mtipservice.APIService.aspect;


import java.util.concurrent.CompletableFuture;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mtipservice.APIService.Constants;

@Aspect
@Component
public class LoggingAspect {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(com.mtipservice.APIService.annotation.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;

		LOGGER.info(joinPoint.getSignature().getName() + " executed in " + executionTime + " ms");
		return proceed;
	}

	@Around("@annotation(com.mtipservice.APIService.annotation.LogRequestResponse)")
	public Object logResquestResponse(ProceedingJoinPoint joinPoint) throws Throwable {
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, joinPoint.getSignature().getName());

		Object[] args = joinPoint.getArgs();
		if (args.length > 0) {
			LOGGER.info(joinPoint.getSignature().getName() + " [OUT]: ");

			for (int i = 0; i < args.length; i++) {
				LOGGER.info(args[i].toString());
			}
		}

		Object proceed = joinPoint.proceed();
		if (proceed != null) {
			LOGGER.info(joinPoint.getSignature().getName() + " [IN]: ");

			if (proceed instanceof CompletableFuture) {
				CompletableFuture<?> res = (CompletableFuture<?>) proceed;

				LOGGER.info(res.get().toString());

			} else if (proceed instanceof ResponseEntity) {
				ResponseEntity<?> res = (ResponseEntity<?>) proceed;

				LOGGER.info(res.getBody().toString());

			} else {
				LOGGER.info(proceed.toString());
			}
		}
		return proceed;
	}

	@Around("@annotation(com.mtipservice.APIService.annotation.LogAsyncRequestResponse)")
	public Object logAsyncResquestResponse(ProceedingJoinPoint joinPoint) throws Throwable {
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, joinPoint.getSignature().getName());

		Object[] args = joinPoint.getArgs();
		if (args.length > 0) {
			MDC.put(Constants.LOGGING_HEADER_SESSION_ID, args[0].toString());

			LOGGER.info(joinPoint.getSignature().getName() + " [OUT]: ");

			for (int i = 0; i < args.length; i++) {
				LOGGER.info(args[i].toString());
			}
		}

		Object proceed = joinPoint.proceed();
		if (proceed != null) {
			LOGGER.info(joinPoint.getSignature().getName() + " [IN]: ");

			if (proceed instanceof CompletableFuture) {
				CompletableFuture<?> res = (CompletableFuture<?>) proceed;

				LOGGER.info(res.get().toString());

			} else if (proceed instanceof ResponseEntity) {
				ResponseEntity<?> res = (ResponseEntity<?>) proceed;

				LOGGER.info(res.getBody().toString());

			} else {
				LOGGER.info(proceed.toString());
			}
		}
		return proceed;
	}

	@Around("@annotation(com.mtipservice.APIService.annotation.LogControllerRequestResponse)")
	public Object logControllerResquestResponse(ProceedingJoinPoint joinPoint) throws Throwable {
		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, joinPoint.getSignature().getName());

		Object[] args = joinPoint.getArgs();
		if (args.length > 0) {
			LOGGER.info(joinPoint.getSignature().getName() + " [IN]: ");

			for (int i = 0; i < args.length; i++) {
				LOGGER.info(args[i].toString());
			}
		}

		Object proceed = joinPoint.proceed();
		if (proceed != null) {
			MDC.put(Constants.LOGGING_HEADER_METHOD_ID, joinPoint.getSignature().getName());

			LOGGER.info(joinPoint.getSignature().getName() + " [OUT]: ");

			if (proceed instanceof CompletableFuture) {
				CompletableFuture<?> res = (CompletableFuture<?>) proceed;

				LOGGER.info(res.get().toString());

			} else if (proceed instanceof ResponseEntity) {
				ResponseEntity<?> res = (ResponseEntity<?>) proceed;

				LOGGER.info(res.getBody().toString());

			} else {
				LOGGER.info(proceed.toString());
			}
		}
		return proceed;
	}

}
