package hello.proxy.pureProxy.decorator;

import hello.proxy.pureProxy.decorator.code.*;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    /**
     * 프록시를 통해서 할 수 있는 기능
     * - 접근 제어
     * - 부가 기능 추가
     *
     * -> 프록시를 통해 부가 기능을 추가하는 것을 데코레이터 패턴이라고 한다.
     */

    @Test
    void noDecorator() {
        RealComponent component = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(component);
        client.execute();
    }

    /**
     * 클라이언트 - Message Decorator - Real Component
     */
    @Test
    void decoratorPattern1() {
        Component component = new RealComponent();
        MessageDecorator decorator = new MessageDecorator(component);
        DecoratorPatternClient client = new DecoratorPatternClient(decorator);
        client.execute();
    }

    /**
     * 클라이언트 - Message Decorator - Time Decorator - Real Component
     */
    @Test
    void decoratorPattern2() {
        Component component = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(component);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
