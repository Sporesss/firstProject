package homework_12_1;

public class ModelForChecking {
//    boolean ifLoginExist;
    private String login = "default";
    private String password = "default";
    private String wordForExit = "EXIT";
    private ListOfUsers listOfUsers[] = ListOfUsers.values();
    private int indexOfLoginInArray;
    private int scopeOfRights[];
    private boolean isIdentified;

//    public boolean getIsIfLoginExist() {
//        return ifLoginExist;
//    }
//
//    public void setIfLoginExist(boolean ifLoginExist) {
//        this.ifLoginExist = ifLoginExist;
//    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWordForExit() {
        return wordForExit;
    }

    public void setWordForExit(String wordForExit) {
        this.wordForExit = wordForExit;
    }

    public ListOfUsers[] getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(ListOfUsers[] listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public int getIndexOfLoginInArray() {
        return indexOfLoginInArray;
    }

    public void setIndexOfLoginInArray(int indexOfLoginInArray) {
        this.indexOfLoginInArray = indexOfLoginInArray;
    }

    public int[] getScopeOfRights() {
        return scopeOfRights;
    }

    public void setScopeOfRights(int[] scopeOfRights) {
        this.scopeOfRights = scopeOfRights;
    }

    public boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(boolean identified) {
        isIdentified = identified;
    }
}
