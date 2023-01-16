package hello.aop.pointcut;

import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class ExecutionTest {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method method;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        method = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        log.info("helloMethod={}", method);
    }

    @Test
    void exactMatch() {
//        pointcut.setExpression("execution(public String hello.aop.member.MemberServiceImpl.hello(String))");
//        assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
        Object a = 1;
        System.out.println("a = " + a);
        a = "hello";
        System.out.println("a = " + a);
    }
}
