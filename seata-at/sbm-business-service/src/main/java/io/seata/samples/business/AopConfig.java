package io.seata.samples.business;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {

    @Pointcut("execution (public * io.seata.samples.business.service..*.*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
        System.out.println("before............");
        try {
            return point.proceed();
        } finally {
            System.out.println("after............");
        }
    }
}
