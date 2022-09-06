package com.web.aspect;

import org.aspectj.lang.annotation.Pointcut;

/** PointcutExpressions */
public class PointcutExpressions {
  @Pointcut("execution(* com.web.controller.*.*(..))")
  private void forControllerPackage() {}

  @Pointcut("execution(* com.web.dao.*.*(..))")
  private void forDaoPackage() {}

  @Pointcut("forControllerPackage() || forDaoPackage()")
  public void forAppFlow() {}
}
