package homework_12;

import java.util.logging.Logger;

public class AuthenticationStart {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(AuthenticationStart.class.getName());
        logger.info("info log");
        logger.warning("warning log");

        AuthenticationSystem authenticationSystem = new AuthenticationSystem();
        authenticationSystem.identification();
        DialogWithUser dialogWithUser = new DialogWithUser();
        dialogWithUser.setAction();
    }
}
