package _08_ReflectionAPIExercise;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Remember to enable assertion, java -ea TestRunner
 * or in intellij, follow the instruction below
 * https://se-education.org/guides/tutorials/intellijUsefulSettings.html
 */

public final class TestRunner {

    private static final List<Class<?>> TESTS = List.of(CalculatorTest.class);

    public static void main(String[] args) throws Exception {

        List<String> passed = new ArrayList<>();
        List<String> failed = new ArrayList<>();

        for (Class<?> klass : TESTS) {
            // TODO: For each test class "klass", do the following:
            //        1. Ensure the class implements the UnitTest interface.
            //        2. Create an instance of the class and cast it to UnitTest.
            //        3. In this example, we only have one klass in TESTS

            if (!UnitTest.class.isAssignableFrom(klass)) {
                throw new IllegalArgumentException("Have to register " + klass.getName() + " to " + Test.class);
            }


            // TODO: For each method that is annotated with @Test:
            //        1. Call beforeEachTest()
            //        2. Invoke the method annotated with @Test
            //        3. Call afterEachTest()
            //        4. Record the test results by adding getTestName(...) to either the "passed" list
            //           of the "failed" list.

            for (Method method : klass.getDeclaredMethods()) {
                // make sure the method has a "Test" annotation
                if (method.getAnnotation(Test.class) != null) {
                    try {
                        // should create a new instance for each method that is annotated.
                        // DON'T create the instance outside the loop
                        // since chances are some fields inside could be altered during the test
                        UnitTest unitTest = (UnitTest) klass.getConstructor().newInstance();
                        unitTest.beforeEachTest();
                        method.invoke(unitTest); // method.invoke()'s input is an object, not a class
                        unitTest.afterEachTest();
                        passed.add(getTestName(klass, method));
                    } catch (Throwable throwable) {
                        failed.add(getTestName(klass, method));
                    }
                }
            }

        }

        System.out.println("Passed tests: " + passed);
        System.out.println("FAILED tests: " + failed);
    }

    private static String getTestName(Class<?> klass, Method method) {
        return klass.getName() + "#" + method.getName();
    }
}
