package hello.proxy.pureProxy.concreteProxy;

import hello.proxy.pureProxy.concreteProxy.code.ConcreteClient;
import hello.proxy.pureProxy.concreteProxy.code.ConcreteLogic;
import hello.proxy.pureProxy.concreteProxy.code.ConcreteTimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteProxy = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteProxy);
        client.execute();
    }

    /**
     * 클라이언트 -> TimeProxy -> ConcreteLogic
     */
    @Test
    void timeProxy() {
        ConcreteLogic concreteProxy = new ConcreteLogic();
        ConcreteTimeProxy timeProxy = new ConcreteTimeProxy(concreteProxy);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }

}
