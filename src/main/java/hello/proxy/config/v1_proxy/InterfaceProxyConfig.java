package hello.proxy.config.v1_proxy;

import hello.proxy.app.v1.*;
import hello.proxy.config.v1_proxy.interface_proxy.OrderControllerProxy;
import hello.proxy.config.v1_proxy.interface_proxy.OrderRepositoryProxy;
import hello.proxy.config.v1_proxy.interface_proxy.OrderServiceProxy;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {
    /**
     * 실제 객체가 아니라 프록시 객체를 빈으로 등록하여 사용
     * -> 실제 객체는 프록시 객체를 통해 참조가 될 뿐..
     *
     * 인터페이스 기반 프록시의 단점
     * - 인터페이스를 만들어야 한다.
     * - 캐스팅
     * 
     * -> 구현을 변경할 가능성이 있는 경우 효과적(항상 인터페이스가 좋지는 않다)
     */

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl orderControllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerProxy(orderControllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl orderServiceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceProxy(orderServiceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl orderRepositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryProxy(orderRepositoryImpl, logTrace);
    }

}
