package _10_DynamicProxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    private final Object tester;

    public ProxyFactory(Object iTester) {
        tester = iTester;
    }

    public Object getNewInstance() {
        return Proxy.newProxyInstance(
                tester.getClass().getClassLoader(),
                tester.getClass().getInterfaces(),
                new TesterInvocationHandler(tester));
    }

}
