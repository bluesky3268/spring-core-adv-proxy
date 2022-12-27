package hello.proxy.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예제의 3가지 상황
 * V1 : 인터페이스와 구현클래스를 스프링 빈으로 수동 등록
 * V2 : 인터페이스가 없는 구현체 클래스를 스프링 빈으로 수동 등록
 * V3 : 컴포넌트 스캔으로 스프링 빈 자동 등록
 */

@Slf4j
@RestController
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;

    public OrderControllerV3(OrderServiceV3 orderService) {
        this.orderService =orderService;
    }

    @GetMapping("/v3/request")
    public String request(String itemId) {
        log.info("V3 - itemId : {}", itemId);
        orderService.orderItem(itemId);
        return "OK";
    }

    @GetMapping("/v3/no-log")
    public String nolog() {
        return "NO LOG OK";
    }
}
