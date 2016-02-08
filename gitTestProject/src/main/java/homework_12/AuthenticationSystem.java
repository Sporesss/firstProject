package homework_12;

import java.util.Scanner;
import homework_12.exceptionsPackage.*;

public class AuthenticationSystem {
    boolean ifLoginExist;
    String login = "default";
    String password = "default";
    static String wordForExit = "EXIT";
    ListOfUsers listOfUsers[] = ListOfUsers.values();
    int indexOfLoginInArray;
    static int scopeOfRights[];

    public AuthenticationSystem() {
        System.out.println("Enter " + wordForExit + " for exit!");
    }

    void identification() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (!ifLoginExist && !login.equalsIgnoreCase(wordForExit) ) {
            System.out.print("Enter your login: ");
            login = scanner.nextLine();
            i++;
            assert i < 10 : "Perhaps it's attempt of login selection!";
            ifLoginExist = checkIdentification(login);
        }
        try {
            authentication();
        } catch (exitException ee) {
            System.out.println("Bye.");
        }
    }

    boolean checkIdentification(String loginForCheck) {
        for (ListOfUsers listElement : listOfUsers) {
            if (listElement.name().equalsIgnoreCase(loginForCheck) || loginForCheck.equalsIgnoreCase(wordForExit)) {
                indexOfLoginInArray = listElement.ordinal();
                return true;
            }
        }
        System.out.println("Incorrect login, try again.");
        return false;
    }

    void authentication() throws exitException {
        Scanner scanner = new Scanner(System.in);
        ListOfUsers currentUser = listOfUsers[indexOfLoginInArray];
        int i = 0;
        while (!password.equals(currentUser.getPassword())) {
            System.out.print("Enter the password: ");
            password = scanner.nextLine();
            i++;
            if (password.equalsIgnoreCase(wordForExit)) {
                throw new exitException();
            }
            assert i < 10 : "Perhaps it's hacking attempt";
        }
        System.out.println("Access was obtained");
        authorization();
    }

    void authorization() {
        listOfUsers[indexOfLoginInArray].printPermissions();
        scopeOfRights = listOfUsers[indexOfLoginInArray].getScopeOfRights();
    }
}
