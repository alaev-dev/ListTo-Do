package dev.alaev.spring.todo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Around("execution(* dev.alaev.spring.todo.dao.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String methodSignatureName = methodSignature.getName();

        System.out.println("Begin of\t" + methodSignatureName);

        Object targetMethodResult = joinPoint.proceed();

        System.out.println("End of\t" + methodSignatureName);

        return targetMethodResult;
    }
}
