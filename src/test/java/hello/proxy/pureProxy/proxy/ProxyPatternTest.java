package hello.proxy.pureProxy.proxy;

import hello.proxy.pureProxy.proxy.code.CacheProxy;
import hello.proxy.pureProxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureProxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();

        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.execute();
        client.execute();
        client.execute();
    }

    /**
     * 클라이언트 - 프록시(CacheProxy) - RealSubject
     *
     * 프록시 패턴의 핵심은
     * ProxyPatternClient와 RealSubject의 코드를 전혀 수정하지 않고 프록시를 도입해서 접근 제어를 한다는 점이다.
     */
    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy proxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(proxy);

        client.execute(); // 실제 객체 호출
        client.execute(); // 프록시
        client.execute(); // 프록시
    }

}
