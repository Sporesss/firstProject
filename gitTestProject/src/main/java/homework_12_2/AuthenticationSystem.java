package homework_12_2;

import homework_12_2.exceptionsPackage.ExitException;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class AuthenticationSystem {

    ModelForChecking model = new ModelForChecking();
    Logger logger = Logger.getLogger(AuthenticationStart.class.getName());
    DialogWithUser dialogWithUser = new DialogWithUser();

    public AuthenticationSystem() {
        System.out.println("Enter " + model.getWordForExit() + " for exit!");
    }

    public void authenticateUserInSystem() {
        try {
            identification(model);
            if(model.getIsIdentified()) {
                authentication(model);
                authorization(model);
                dialogWithUser.setAction(model);
            }
        } catch(ExitException e) {
            logger.warning("'EXIT' was entered.");
        } catch (IOException ioe) {
            logger.warning("'IOException' was thrown from DialogWithUser class, setAction method.");
        }
    }

    void identification(ModelForChecking someModel) throws ExitException {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String login = someModel.getLogin();
        while (!someModel.getIsIdentified() && !login.equalsIgnoreCase(someModel.getWordForExit())) {
            System.out.print("Enter your login: ");
            login = scanner.nextLine();
            logger.info("Was entered login '" + login + "'.");
            i++;
            assert i < 10 : "Perhaps it's attempt of login selection!";
            if (!login.equalsIgnoreCase(someModel.getWordForExit())) {
                someModel.setLogin(login);
                checkIdentification(someModel);
            } else if (login.equalsIgnoreCase(someModel.getWordForExit())) {
                throw new ExitException();
            }
        }
    }

    void  checkIdentification(ModelForChecking someModel) {
        for (ListOfUsers listElement : someModel.getListOfUsers()) {
            if(listElement.name().equalsIgnoreCase(someModel.getLogin())) {
                someModel.setIndexOfLoginInArray(listElement.ordinal());
                someModel.setIsIdentified(true);
                logger.info("Identification was successful");
            }
        }
        if (!someModel.getIsIdentified()) {
            System.out.println("Incorrect login, try again.");
        }
    }

    void authentication(ModelForChecking someModel) throws ExitException {
        Scanner scanner = new Scanner(System.in);
        ListOfUsers currentUser = someModel.getListOfUsers()[someModel.getIndexOfLoginInArray()];
        int i = 0;
        String password = someModel.getPassword();
        while (!password.equals(currentUser.getPassword())) {
            System.out.print("Enter the password: ");
            password = scanner.nextLine();
            logger.info("Was entered login '" + password + "'.");
            i++;
            if (password.equalsIgnoreCase(model.getWordForExit())) {
                throw new ExitException();
            } else if (!password.equals(currentUser.getPassword())) {
                System.out.println("Incorrect password, try again.");
            }
            assert i < 10 : "Perhaps it's hacking attempt";
        }
        System.out.println("Access was obtained");
    }

    void authorization(ModelForChecking someModel) {
        someModel.getListOfUsers()[someModel.getIndexOfLoginInArray()].printPermissions();
        someModel.setScopeOfRights(someModel.getListOfUsers()[someModel.getIndexOfLoginInArray()].getScopeOfRights());
    }
}
