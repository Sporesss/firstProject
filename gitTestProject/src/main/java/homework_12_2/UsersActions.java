package homework_12_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

public class UsersActions {
    Logger logger = Logger.getLogger(UsersActions.class.getName());
    Handler handler;


    ArrayList<String> arrayList = new ArrayList<String>();

    public UsersActions() {
        fillingDefaultArrayList();
        createHandler();
    }

    void fillingDefaultArrayList() {
        arrayList.add("God");
        arrayList.add("Save");
        arrayList.add("the");
        arrayList.add("Queen");
    }

    void createHandler() {
        try {
            handler = new FileHandler("%h/UsersActions.txt", 500000, 5);
        } catch (IOException ioe) {
            System.out.println("IOException in UsersActions class");
        }
        handler.setFormatter(new NewFormatter());
        logger.addHandler(handler);
    }

    void userReadData() {
        logger.info("User Read Data");
        for (String arrayElement : arrayList) {
            System.out.print(arrayElement + " ");
        }
        System.out.println();
    }

    void userAddData() {
        logger.info("User Add Data");
        Scanner scanner = new Scanner(System.in);
        System.out.print("What you want to add? Enter it: ");
        arrayList.add(scanner.nextLine());
    }

    void userDeleteData() {
        logger.info("User Delete Data");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which one do you want to delete? Enter index: ");
        try {
            arrayList.remove(scanner.nextInt());
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("You could choose number from 0 to " + (arrayList.size() - 1));
        }
    }

    void userEraseAll() {
        logger.info("User Erase All");
        arrayList.clear();
    }

    class NewFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            String message = record.getMessage();
            return "Test NewFormatter! \n" + message + "\n";
        }
    }
}
