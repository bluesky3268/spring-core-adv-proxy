package hello.proxy.app.v1;

import lombok.extern.slf4j.Slf4j;

/**
 * 예제의 3가지 상황
 * V1 : 인터페이스와 구현클래스를 스프링 빈으로 수동 등록
 * V2 : 인터페이스가 없는 구현체 클래스를 스프링 빈으로 수동 등록
 * V3 : 컴포넌트 스캔으로 스프링 빈 자동 등록
 */
@Slf4j
public class OrderControllerV1Impl implements OrderControllerV1{

    private final OrderServiceV1 orderService;

    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        log.info("V1 - itemId : {}", itemId);
        return "OK";
    }

    @Override
    public String nolog() {
        return "NO LOG OK";
    }
}
