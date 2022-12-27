package hello.proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.app.v3.OrderControllerV3;
import hello.proxy.config.AppV2Config;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppV2Config.class);
        OrderControllerV2 controllerV2 = ac.getBean(OrderControllerV2.class);
        OrderServiceV2 service = ac.getBean(OrderServiceV2.class);

        Assertions.assertThat(controllerV2).isInstanceOf(OrderControllerV2.class);
        Assertions.assertThat(service).isInstanceOf(OrderServiceV2.class);
    }

}
