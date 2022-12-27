package hello.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 예제의 3가지 상황
 * V1 : 인터페이스와 구현클래스를 스프링 빈으로 수동 등록
 * V2 : 인터페이스가 없는 구현체 클래스를 스프링 빈으로 수동 등록
 * V3 : 컴포넌트 스캔으로 스프링 빈 자동 등록
 */

@Slf4j
@RequestMapping
@ResponseBody
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        log.info("V2 - itemId : {}", itemId);
        return "OK";
    }

    @GetMapping("/v2/no-log")
    public String nolog() {
        return "NO LOG OK";
    }

}
