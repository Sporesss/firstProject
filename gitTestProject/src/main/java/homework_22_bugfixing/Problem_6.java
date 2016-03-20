package homework_22_bugfixing;

public class Problem_6 {

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);

        int numberForExit = 4;     //was fixed

        if (num == numberForExit || num > numberForExit)    //was fixed
            return;
        else
            recursivePrint(++num);
    }

    public static void main(String[] args) {
        Problem_6.recursivePrint(10);
    }

}
