package homework_15_bags.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionProblemInvokeMethodDoesNotWork2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
        Class userClass = Class.forName(User.class.getName());
        User user = (User) userClass.newInstance();
        Field field = userClass.getDeclaredField("veryImportantField");    // the code was changed
        field.setAccessible(true);                                         // the code was changed
        field.set(user, "newValueForVeryImportantField");
        System.out.println("after changes --->>>> " + user.getVeryImportantField());
    }
}
