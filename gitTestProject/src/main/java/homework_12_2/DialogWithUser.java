package homework_12_2;

import homework_12_2.exceptionsPackage.BoundOutException;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class DialogWithUser {
    UsersActions usersActions = new UsersActions();
    Logger logger = Logger.getLogger(DialogWithUser.class.getName());

    void runAction(int indexOfWish) {
        switch (indexOfWish) {
            case 1:
                usersActions.userReadData();
                break;
            case 2:
                usersActions.userAddData();
                break;
            case 3:
                usersActions.userDeleteData();
                break;
            case 4:
                usersActions.userEraseAll();
                break;
        }
    }

    void setAction(ModelForChecking someModel) throws IOException {
        Handler handler = new FileHandler("%h/DialogWithUser_log.txt", 500000, 5);
        handler.setFormatter(new XMLFormatter());
        logger.addHandler(handler);

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want? \n1) Read data \n2) Add data \n3) Delete data \n4) Erase all \nEnter 1,2,3 or 4");
        String userInput = scanner.nextLine();
        logger.info("Was entered '" + userInput + "'.");
        while (!userInput.equalsIgnoreCase(someModel.getWordForExit())) {
            try {
                int menuItem = allChecksOfUserInput(userInput, someModel, logger);
                runAction(menuItem);
            } catch (BoundOutException boe) {
                System.out.println("What? You need have entered 1,2,3 or 4!");
            }
            System.out.println("What do you want? \n1) Read data \n2) Add data \n3) Delete data \n4) Erase all \nEnter 1,2,3 or 4");
            userInput = scanner.nextLine();
            logger.info("Was entered '" + userInput + "'.");
        }
    }

    int allChecksOfUserInput(String userInput, ModelForChecking someModel, Logger someLogger) throws BoundOutException {
        int choice = 0;
        int menuItem;

        try {
            choice = Integer.parseInt(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("You need have entered 1,2,3 or 4!");
            someLogger.warning("'NumberFormatException' -> wasn't entered number");
        }

        if (choice < 0 || choice >= ListOfUsers.SUPER_USER.getScopeOfRights().length) {
            throw new BoundOutException();
        }

        try {
            menuItem = someModel.getScopeOfRights()[choice];
        } catch (ArrayIndexOutOfBoundsException ioe) {
            menuItem = 0;
            System.out.println("Your rights aren't enough!");
            someLogger.warning("Exception -> rights aren't enough!");
        }
        return menuItem;
    }
}
