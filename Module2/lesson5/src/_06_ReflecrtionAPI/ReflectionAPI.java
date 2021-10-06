package _06_ReflecrtionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAPI {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> classString = " ".getClass();
        //Class<String> classString = String.class;
        Class<int[]> classIntArr = int[].class;

        Class<?> c = Class.forName("java.lang.String");
        System.out.println(c.getName());
        System.out.println(classIntArr.getName());
        System.out.println(classString.getName());

        Method m = String.class.getMethod("equals", Object.class);
        System.out.println(m.invoke("123", "123"));
        TestClass testClass = new TestClass(1, 2);
        Constructor constructor = TestClass.class.getConstructor(int.class, int.class);
        TestClass testClass1 = (TestClass) constructor.newInstance(3, 4);
        System.out.println(testClass1.getPublicInt());


        //Method m = String.class.getMethod("compareTo");
        //System.out.println(m.invoke("A", "B"));


    }


}
