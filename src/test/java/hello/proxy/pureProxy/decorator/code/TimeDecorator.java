package hello.proxy.pureProxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import static java.lang.String.valueOf;

@Slf4j
public class TimeDecorator implements Component{

    private Component target;

    public TimeDecorator(Component target) {
        this.target = target;
    }

    @Override
    public String operation() {
        long startTime = System.currentTimeMillis();

        log.info("===== startTime : {} =====", valueOf(LocalDateTime.now()));
        String result = target.operation();

        long endTime = System.currentTimeMillis();
        log.info("===== endTime : {} =====", valueOf(LocalDateTime.now()));
        log.info("===== resultTime : {}ms =====", endTime - startTime);
        return result;
    }
}
