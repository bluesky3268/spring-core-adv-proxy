package hello.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderRepositoryV2 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalArgumentException("예외발생함");
        }
        log.info("V2 - repository");
        sleep(1000);
    }

    private void sleep(int milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

