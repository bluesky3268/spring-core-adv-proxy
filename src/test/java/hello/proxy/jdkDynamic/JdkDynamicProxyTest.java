package hello.proxy.jdkDynamic;

import hello.proxy.jdkDynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // Proxy 생성하기
        // params : 어느 클래스 로더에, 어떤 인터페이스를 기반으로 프록시를 만들지, 프록시를 사용할 로직이 뭔지
//        Object proxy = Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        String result = proxy.call();

        log.info("result : {}", result);
        log.info("========================================");
        log.info("target.getClass() : {}", target.getClass());
        log.info("proxy.getClass() : {}", proxy.getClass());

    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // Proxy 생성하기
        // params : 어느 클래스 로더에, 어떤 인터페이스를 기반으로 프록시를 만들지, 프록시를 사용할 로직이 뭔지
//        Object proxy = Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        String result = proxy.call();

        log.info("result : {}", result);
        log.info("========================================");
        log.info("target.getClass() : {}", target.getClass());
        log.info("proxy.getClass() : {}", proxy.getClass());

    }
}
