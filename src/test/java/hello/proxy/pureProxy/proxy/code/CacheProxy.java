package hello.proxy.pureProxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 프록시도 실제 Subject와 구조가 같아야 하기 때문에 Subject를 구현해주고 
 * 또한 실제 객체를 참조로 가지고 있어야 함
 */

@Slf4j
public class CacheProxy implements Subject{

    private Subject target;
    private String cacheData;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cacheData == null) {
            cacheData = target.operation();
        }
        return cacheData;
    }
}
