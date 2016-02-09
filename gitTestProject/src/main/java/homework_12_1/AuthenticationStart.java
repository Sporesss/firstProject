package homework_12_1;

import java.util.logging.Logger;

public class AuthenticationStart {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(AuthenticationStart.class.getName());
        logger.info("info log");
        logger.warning("warning log");

        AuthenticationSystem authenticationSystem = new AuthenticationSystem();
//        boolean ifExit = authenticationSystem.runIdentification();
//        if (ifExit) {
//            DialogWithUser dialogWithUser = new DialogWithUser();
//            dialogWithUser.setAction();
//        }
        authenticationSystem.authenticateUserInSystem();
//        DialogWithUser dialogWithUser = new DialogWithUser();
//        dialogWithUser.setAction();
    }
}
