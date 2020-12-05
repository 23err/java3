package ru.geekbrains.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class TestRunner {
    public static void start(String className) {
        try {
            start(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class acceptedClass) {

        try {
            Comparator<Method> comparator = new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    int o1Prior = o1.getAnnotation(Test.class).priority();
                    int o2Prior = o2.getAnnotation(Test.class).priority();
                    if (o1 == o2) return 0;

                    if (o1Prior < o2Prior)
                        return 1;
                    else return -1;
                }
            };
            TreeSet<Method> invokeMethod = new TreeSet<>(comparator);
            Method[] methods = acceptedClass.getMethods();
            Method beforeSuiteMethod = null, afterSuiteMethod = null;

            for (Method method : methods) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    if (beforeSuiteMethod != null)
                        throw new RuntimeException("BeforeSuite метод должен быть первым и должен быть один!");
                    beforeSuiteMethod = method;
                }

                if (method.isAnnotationPresent(Test.class)) {
                    invokeMethod.add(method);
                }

                if (method.isAnnotationPresent(AfterSuite.class)) {
                    if (afterSuiteMethod != null)
                        throw new RuntimeException("AfterSuite метод должен быть только один!");
                    afterSuiteMethod = method;
                }
            }

            for (Method method : invokeMethod) {
                Object obj = acceptedClass.getConstructor().newInstance();
                if (beforeSuiteMethod != null)
                    beforeSuiteMethod.invoke(obj);
                method.invoke(obj);
                if (afterSuiteMethod !=null)
                    afterSuiteMethod.invoke(obj);

            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
