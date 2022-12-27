package hello.proxy.config.v2_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.config.v2_proxy.concrete_proxy.OrderControllerConcreteProxy;
import hello.proxy.config.v2_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import hello.proxy.config.v2_proxy.concrete_proxy.OrderServiceConcreteProxy;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    /**
     * 클래스 기반 프록시의 제약점
     * - 부모 클래스의 생성자를 호출해야 함
     * - final이 붙어 있는 클래스는 상속이 불가능
     * - final이 붙어 있는 메서드는 오버라이딩 불가능
     *
     *
     */

    @Bean
    public OrderRepositoryV2 orderRepositoryConcrete(LogTrace logTrace) {
        OrderRepositoryV2 orderRepositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(orderRepositoryImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderserviceConcrete(LogTrace logTrace) {
        OrderServiceV2 orderService = new OrderServiceV2(orderRepositoryConcrete(logTrace));
        return new OrderServiceConcreteProxy(orderService, logTrace);
    }

    @Bean
    public OrderControllerV2 orderControllerConcrete(LogTrace logTrace) {
        OrderControllerV2 orderControllerConcrete = new OrderControllerV2(orderserviceConcrete(logTrace));
        return new OrderControllerConcreteProxy(orderControllerConcrete, logTrace);
    }

}
