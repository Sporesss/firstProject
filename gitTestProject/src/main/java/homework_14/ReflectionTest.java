package homework_14;

import java.lang.reflect.*;

public class ReflectionTest {
    static Palindrome palindrome = new Palindrome();
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        System.out.println(palindrome);
        Class palindromeClass = Class.forName(Palindrome.class.getName());  //Что здесь происходит? Создаём копию класса Palindrome?
        System.out.println("palindromeClass ----> " + palindromeClass);
        Object o = palindromeClass.newInstance();
        System.out.println("New instance ----> " + o);

        getAllConstructors(palindromeClass);
        getAllMethods(palindromeClass);
        invokePrivateMethod(palindromeClass, o);
    }

    private static void getAllConstructors(Class someClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Constructor constructors[] = someClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor " + constructor);
            System.out.println("Constructor " + constructor.getName());
            Parameter parameters[] = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter name: " + parameter.getName());   // Почему выводятся параметры только второго конструктора?
                System.out.println("Parameter type: " + parameter.getType());   // Из-за того, что у первого конструктора нет параметров, JDK даже не заходит в этот цикл?
            }
            int modifiers = constructor.getModifiers();
            System.out.println(getAllModifiers(modifiers));
        }
    }

    private static void getAllMethods(Class someClass) {
        Method methods[] = someClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(" There are method: " + method);
            System.out.println(" Method name: " + method.getName());
        }
    }

    private static void invokePrivateMethod(Class someClass, Object someObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (someObject instanceof Palindrome) {
            Palindrome palindromeTmp = (Palindrome) someObject;
            Method privateMethod = someClass.getDeclaredMethod("privateMethodFromPalindrome");
            privateMethod.setAccessible(true);
            privateMethod.invoke(palindromeTmp, null);
        }
    }

    private static String getAllModifiers(int modifier) {
        StringBuilder answer = new StringBuilder();
        if (Modifier.isAbstract(modifier)) {
            answer.append(" abstract ");
        }
        if (Modifier.isPublic(modifier)) {
            answer.append(" public ");
        }
        if (Modifier.isPrivate(modifier)) {
            answer.append(" private ");
        }
        if (Modifier.isStatic(modifier)) {
            answer.append(" static ");
        }
        return answer.toString();
    }
}
