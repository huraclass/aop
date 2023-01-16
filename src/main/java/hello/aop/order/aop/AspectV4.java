package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV4 {
    @Around("hello.aop.order.aop.Pointcuts.allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("[log start] {}", joinPoint.getSignature());
        Object proceed = joinPoint.proceed();
        log.info("[log end]");
        return proceed;
    }
    @Around("hello.aop.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        try {
            log.info("트랜젝션 시작");
            Object proceed = joinPoint.proceed();
            log.info("트랜젝션 커밋");
            return proceed;
        } catch (Exception e) {
            log.info("트랜젝션 롤백");
            throw e;
        }finally {
            log.info("리소스 반환");
        }
    }
}
