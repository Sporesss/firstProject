package homework_15_bags.reflection;

import java.lang.reflect.Method;

public class ReflectionProblem1 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class userClass = Class.forName(User.class.getName());
        Method[] methods = userClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Object object = userClass.newInstance();
        if (object instanceof User) {
            User user = (User) object;
            user.getName();
            user.getSurName();
        }

    }

}


