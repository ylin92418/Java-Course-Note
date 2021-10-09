package _10_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TesterInvocationHandler implements InvocationHandler {

    Object target;

    public TesterInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy starts running...");
        System.out.println("Proxy: " + target.getClass());
        System.out.println("Method: " + method);
        Object returnObject = method.invoke(target, args); // pass in target and args
        System.out.println("Proxy submit...");
        return returnObject;
    }
}
