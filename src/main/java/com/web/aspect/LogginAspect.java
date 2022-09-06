package com.web.aspect;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/** LogginAspect */
@Aspect
@Component
public class LogginAspect {
  private final Logger logger = Logger.getLogger(getClass().getName());

  @Before("com.web.aspect.PointcutExpressions.forAppFlow()")
  private void beforeAppFlow(final JoinPoint joinPoint) {
    logger.info(
        "======> @Before is running on method: " + joinPoint.getSignature().toShortString());

    for (final Object ob : joinPoint.getArgs()) {
      logger.info("======> argument: " + ob);
    }
  }
}
