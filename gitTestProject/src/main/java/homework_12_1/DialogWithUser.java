package homework_12_1;

import homework_12_1.exceptionsPackage.BoundOutException;

import java.util.Scanner;

public class DialogWithUser {
    UsersActions usersActions = new UsersActions();
//    ModelForChecking model = new ModelForChecking();

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

    void setAction(ModelForChecking someModel) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want? \n1) Read data \n2) Add data \n3) Delete data \n4) Erase all \nEnter 1,2,3 or 4");
        String userInput = scanner.nextLine();
        while (!userInput.equalsIgnoreCase(someModel.getWordForExit())) {
            try {
                int menuItem = allChecksOfUserInput(userInput, someModel);
                runAction(menuItem);
            } catch (BoundOutException boe) {
                System.out.println("What? You need have entered 1,2,3 or 4!");
            }
            System.out.println("What do you want? \n1) Read data \n2) Add data \n3) Delete data \n4) Erase all \nEnter 1,2,3 or 4");
            userInput = scanner.nextLine(); // add exceptions!!!
        }
    }

    int allChecksOfUserInput(String userInput, ModelForChecking someModel) throws BoundOutException {
        int choice = 0;
        int menuItem;

        try {
            choice = Integer.parseInt(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("You need have entered 1,2,3 or 4!");
        }

        if (choice < 0 || choice >= ListOfUsers.SUPER_USER.getScopeOfRights().length) {
            throw new BoundOutException();
        }

        try {
            menuItem = someModel.getScopeOfRights()[choice];
        } catch (ArrayIndexOutOfBoundsException ioe) {
            menuItem = 0;
            System.out.println("Your rights aren't enough!");
        }
        return menuItem;
    }
}
