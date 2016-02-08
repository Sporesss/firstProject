package homework_12;

import java.util.Scanner;
import homework_12.exceptionsPackage.*;

public class DialogWithUser {
    UsersActions usersActions = new UsersActions();

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

    void setAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want? \n1) Read data \n2) Add data \n3) Delete data \n4) Erase all \nEnter 1,2,3 or 4");
        String userInput = scanner.nextLine();
        while (!userInput.equalsIgnoreCase(AuthenticationSystem.wordForExit)) {
            try {
                int menuItem = allChecksOfUserInput(userInput);
                runAction(menuItem);
            } catch (boundOutException boe) {
                System.out.println("What? You need have entered 1,2,3 or 4!");
            }
            System.out.println("What do you want? \n1) Read data \n2) Add data \n3) Delete data \n4) Erase all \nEnter 1,2,3 or 4");
            userInput = scanner.nextLine(); // add exceptions!!!
        }
    }

    int allChecksOfUserInput(String userInput) throws boundOutException {
        int choice = 0;
        int menuItem;

        try {
            choice = Integer.parseInt(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("You need have entered 1,2,3 or 4!");
        }

        if (choice < 0 || choice >= ListOfUsers.SUPER_USER.getScopeOfRights().length) {
            throw new boundOutException();
        }

        try {
            menuItem = AuthenticationSystem.scopeOfRights[choice];
        } catch (ArrayIndexOutOfBoundsException ioe) {
            menuItem = 0;
            System.out.println("Your rights aren't enough!");
        }
        return menuItem;
    }
}
