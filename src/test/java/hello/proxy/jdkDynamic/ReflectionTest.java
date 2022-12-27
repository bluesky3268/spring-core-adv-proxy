package hello.proxy.jdkDynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {
    /**
     * reflection은 런타임에 동작하기 때문에 컴파일 에러를 잡을 수가 없음
     * -> 따라서 안쓰는 게 제일 좋다
     *
     * 동적 프록시를 안쓰는 경우, 적용해야할 인터페이스 혹은 클래스가 1000개면 프록시도 1000개를 만들어야 한다...
     * JDK동적 프록시는 인터페이스를 기반으로 프록시를 동적으로 만들어준다.
     * 단, 프록시에 적용할 로직은 따로 작성해야 한다. - InvocationHandler 인터페이스를 구현해야 함
     *  - 제공되는 파라미터 
     *          - Object proxy : 프록시 자신
     *          - Method method : 호출할 메서드
     *          - Object[] args : 메서드를 호출할 때 전달할 인수
     */

    @Test
    void reflectionTest() {
        Hello target = new Hello();

        log.info("start");
        String resultA = target.callA();
        log.info("result : {}", resultA);

        log.info("start");
        String resultB = target.callB();
        log.info("result : {}", resultB);

    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 클래스 메타 정보 획득
        Class<?> classHello = Class.forName("hello.proxy.jdkDynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // 클래스의 callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target); // 실제 인스턴스의 메서드 호출
        log.info("result1 : {}", result1);

        // 클래스의 callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target); // 실제 인스턴스의 메서드 호출
        log.info("result2 : {}", result2);
    }


    @Test
    void reflectionTest2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        // 클래스 메타 정보 획득
        Class<?> classHello = Class.forName("hello.proxy.jdkDynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // 클래스의 callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);


        // 클래스의 callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result : {}", result);
        log.info("end");

    }

    @Slf4j
    static class Hello{
        public String callA() {
            log.info("call A");
            return "A";
        }
        public String callB() {
            log.info("call B");
            return "B";
        }
    }
}
