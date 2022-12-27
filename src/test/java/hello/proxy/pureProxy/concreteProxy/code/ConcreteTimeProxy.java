package hello.proxy.pureProxy.concreteProxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteTimeProxy extends ConcreteLogic{

    private ConcreteLogic realLogic;

    public ConcreteTimeProxy(ConcreteLogic realLogic) {
        this.realLogic = realLogic;
    }

    @Override
    public String operation() {
        log.info("Concrete Time Proxy 실행");

        long startTime = System.currentTimeMillis();
        String result = realLogic.operation();
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("resultTime : {}ms", resultTime);

        log.info("Concrete Time Proxy 종료");

        return result;
    }
}
