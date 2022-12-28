package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
//        log.info("startTime : {}", startTime);

        /**
         * 프록시를 생성하는 단계에서 target클래스의 정보를 같이 넘긴다.
         * -> target클래스의 모든 정보는 invocation안에 들어가 있다.
         * -> target을 찾아서 인수를 넘겨서 알아서 처리해준다.
         */
        Object result = invocation.proceed();

        long endTime = System.currentTimeMillis();
//        log.info("endTime : {}", endTime);
        long resultTime = endTime - startTime;
        log.info("resultTime : {}", resultTime);

        return result;
    }

}
