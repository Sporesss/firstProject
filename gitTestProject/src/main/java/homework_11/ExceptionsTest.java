package homework_11;

public class ExceptionsTest {
    private String name;

    public ExceptionsTest(String name) {
        this.name = name;
    }

    public void print() {
        printString(name);
    }

    private void printString(String s) {
        if (s == null) {
            throw new UncheckedError();
        }
        System.out.println(s + " (" + s.length() + ")");
    }

    public void printArrayIndex() throws CheckedError {
        char [] chars = name.toCharArray();
        if (chars.length <= 3) {
            throw new CheckedError();
        }
        System.out.println(chars[3]);
    }

    public static void main(String[] args) {
        ExceptionsTest exceptionsTest = new ExceptionsTest("cat");
        exceptionsTest.print();
        try {
            exceptionsTest.printArrayIndex();
        } catch (CheckedError e) {
            System.out.println("The word is too short");
        }
    }
}
