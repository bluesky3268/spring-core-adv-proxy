package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void cglibTest() {
        /**
         * 인터페이스가 없는데 동적 프록시를 만들 수 있을까 -> CGLIB를 이용해서 가능함
         * 근데 스프링에서는 굳이 CGLIB를 쓸 필요없이 프록시 팩토리라는 걸 쓰면 됨
         *
         */
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();

        log.info("target.getClass() : {}", target.getClass());
        log.info("proxy.getClass() : {}", proxy.getClass());

        proxy.call();
    }
}
