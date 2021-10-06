package _10_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class DynamicProxy {
    public static void main(String[] args) {
        Set<String> targetSet = new HashSet<>();

        Object proxy = Proxy.newProxyInstance(
                DynamicProxy.class.getClassLoader(),
                new Class[]{Set.class},
                new LogginInvocationHandler(targetSet)
        );

        Set<String> loggedSet = (Set<String>) proxy;

        // set's method
        loggedSet.add("item");
        System.out.println(loggedSet.contains("item"));
    }

    static class LogginInvocationHandler implements InvocationHandler {

        private final Object targetObject;

        public LogginInvocationHandler(Object o) {
            targetObject = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            System.out.println(targetObject.getClass() + "." + method.getName() + "() is called");
            return method.invoke(targetObject, args);
        }

    }
}
