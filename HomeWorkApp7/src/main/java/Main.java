import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cls = MyClass.class;
        Object obj = cls.getDeclaredConstructor().newInstance();

        Method[] methods = cls.getDeclaredMethods();
        List<Method> listTest = new ArrayList<>();

        Method before = null;
        Method after = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if(before == null){
                    before = method;
                }else throw new RuntimeException("Может быть только один такой метод");
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if(after == null){
                    after = method;
                }else throw new RuntimeException("Может быть только один такой метод");
            }
            if (method.isAnnotationPresent(Test.class)){
                listTest.add(method);
            }
        }
        listTest.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
            }
        });
        if (before != null) {
            listTest.add(0, before);
        }
        if (after != null) {
            listTest.add(after);
        }

        for (Method method : listTest) {
            method.invoke(obj,null);
        }
    }
}