package homework_10.homework_10_bugs.bug_6_NullPointerException;

public class Printer {
    private String name;

    Printer (String name) {   // was fixed
        this.name = name;
    }

    public void print() {
        printString(name);
    }

    private void printString(String s) {
        System.out.println(s + " (" + s.length() + ")");
    }

    public static void main(String[] args) {
        Printer printer = new Printer("Samsung");   // was fixed
        printer.print();
    }
}