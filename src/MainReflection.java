import JavaProject.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        Field fieldR = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        System.out.println(fieldR.getName());
        field.setAccessible(true);
        System.out.println(field.get(r));
        field.set(r, "uuu1");
        Method method = resumeClass.getMethod("toString");
        Object res = method.invoke(r);
        System.out.println(res);

    }
}
