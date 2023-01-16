package hello.aop.member;

import hello.aop.member.annotation.ClassAop;
import hello.aop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@Component
@ClassAop
public class MemberServiceImpl implements MemberService {
    @Override
    @MethodAop("test value")
    public String hello(String params) {
        return "OK";
    }

    public String internal(String param) {
        return "OK";
    }
}
