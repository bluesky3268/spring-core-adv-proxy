package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderRepositoryV1;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderRepositoryProxy implements OrderRepositoryV1 {

    private OrderRepositoryV1 target;
    private LogTrace logTrace;

    public OrderRepositoryProxy(OrderRepositoryV1 orderRepositoryV1, LogTrace logTrace) {
        this.target = orderRepositoryV1;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("orderRepositoryProxy - save()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
