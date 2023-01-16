package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV1 {

    @Around("execution(* hello.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint)throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());
        Object proceed = joinPoint.proceed();
//        log.info(proceed.toString());
//        log.info("proceed:",proceed);
        log.info("[log end]");
        return proceed;
    }
}
