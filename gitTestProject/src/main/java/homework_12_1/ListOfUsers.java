package homework_12_1;

public enum ListOfUsers {
    SUPER_USER {
        String superUserPassword = "superuserpassword";
        String permissions = "Your access rights: you are GOD!";
        int scopeOfRights[] = {0,1,2,3,4};
        @Override
        String getPassword() {
            return superUserPassword;
        }
        @Override
        void printPermissions() {
            System.out.println(permissions);
        }
        @Override
        int[] getScopeOfRights() {
            return scopeOfRights;
        }
    },
    ADMIN {
        String adminPassword = "adminpassword";
        String permissions = "Your access rights: you can read, write and delete.";
        int scopeOfRights[] = {0,1,2,3};
        @Override
        String getPassword() {
            return adminPassword;
        }
        @Override
        void printPermissions() {
            System.out.println(permissions);
        }
        @Override
        int[] getScopeOfRights() {
            return scopeOfRights;
        }
    },
    USER {
        String userPassword = "userpassword";
        String permissions = "Your access rights: you can read and write.";
        int scopeOfRights[] = {0,1,2};
        @Override
        String getPassword() {
            return userPassword;
        }
        @Override
        void printPermissions() {
            System.out.println(permissions);
        }
        @Override
        int[] getScopeOfRights() {
            return scopeOfRights;
        }
    },
    GUEST {
        String guestPassword = "guestpassword";
        String permissions = "Your access rights: just watch, don't touch!";
        int scopeOfRights[] = {0,1};
        @Override
        String getPassword() {
            return guestPassword;
        }
        @Override
        void printPermissions() {
            System.out.println(permissions);
        }
        @Override
        int[] getScopeOfRights() {
            return scopeOfRights;
        }
    };

    String getPassword() {
       return "default";
    }

    void printPermissions() {
        System.out.println();
    }

    int[] getScopeOfRights() {
        int someArray[] = {0};
        return someArray;
    }
}
