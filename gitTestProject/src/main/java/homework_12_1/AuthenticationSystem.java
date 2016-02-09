package homework_12_1;

import homework_12_1.exceptionsPackage.ExitException;

import java.util.Scanner;
import java.util.logging.Logger;

public class AuthenticationSystem {
//    boolean ifLoginExist;
//    String login = "default";
//    String password = "default";
////    static String ModelForChecking.getWordForExit() = "EXIT";
////    ListOfUsers listOfUsers[] = ListOfUsers.values();
//    int indexOfLoginInArray;
//    static int scopeOfRights[];
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
            logger.warning("EXIT was entered.");
        }
//        return yoursModel.isAuthenticationSuccessful ;
    }

    void identification(ModelForChecking someModel) throws ExitException {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String login = someModel.getLogin();
        while (!someModel.getIsIdentified() && !login.equalsIgnoreCase(someModel.getWordForExit())) {
            System.out.print("Enter your login: ");
            login = scanner.nextLine();
            i++;
            assert i < 10 : "Perhaps it's attempt of login selection!";
            if (!login.equalsIgnoreCase(someModel.getWordForExit())) {
                someModel.setLogin(login);
                checkIdentification(someModel);
//                model.setIsIdentified(checkIdentification(login));
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
            }
//            model.setIsIdentified(true);
        }
    }


//    boolean runIdentification() {
//        try {
//            identification();
//            return true;
//        } catch (ExitException ee) {
//            System.out.println("Bye.");
//            return false;
//        }
//    }

//    void identification() throws ExitException {
//        Scanner scanner = new Scanner(System.in);
//        int i = 0;
//        String login = model.getLogin();
//        while (!model.getIsIfLoginExist() && !login.equalsIgnoreCase(model.getWordForExit()) ) {
//            System.out.print("Enter your login: ");
//            login = scanner.nextLine();
//            i++;
//            assert i < 10 : "Perhaps it's attempt of login selection!";
//            if (!login.equalsIgnoreCase(model.getWordForExit())) {
//                model.setIfLoginExist(checkIdentification(login));
//            } else if (login.equalsIgnoreCase(model.getWordForExit())) {
//                throw new ExitException();
//            }
//        }
//        authentication();
//    }

//    boolean checkIdentification(String loginForCheck) {
//        for (ListOfUsers listElement : listOfUsers) {
//            if (listElement.name().equalsIgnoreCase(loginForCheck)) {
//                indexOfLoginInArray = listElement.ordinal();
//                return true;
//            }
//        }
//        System.out.println("Incorrect login, try again.");
//        return false;
//    }

    void authentication(ModelForChecking someModel) throws ExitException {
        Scanner scanner = new Scanner(System.in);
        ListOfUsers currentUser = someModel.getListOfUsers()[someModel.getIndexOfLoginInArray()];
        int i = 0;
        String password = someModel.getPassword();
        while (!password.equals(currentUser.getPassword())) {
            System.out.print("Enter the password: ");
            password = scanner.nextLine();
            i++;
            if (password.equalsIgnoreCase(model.getWordForExit())) {
                throw new ExitException();
            }
            assert i < 10 : "Perhaps it's hacking attempt";
        }
        System.out.println("Access was obtained");
//        authorization();
    }

    void authorization(ModelForChecking someModel) {
        someModel.getListOfUsers()[someModel.getIndexOfLoginInArray()].printPermissions();
        someModel.setScopeOfRights(someModel.getListOfUsers()[someModel.getIndexOfLoginInArray()].getScopeOfRights());
//        scopeOfRights = listOfUsers[indexOfLoginInArray].getScopeOfRights();
    }
}
