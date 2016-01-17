package homework_7.bug_5;

public class NullPointerException {
    public static void main(String[] args) {
        CustomList[] customLists = new CustomList[5];  // the customLists is empty

        for (int i = 0; i < customLists.length; i++) {
            customLists[i] = new CustomList();          // the customLists is filling
        }

        customLists[0].name = "newName";
    }
}

class CustomList {
    public String name;
    public String value;

    public CustomList() {
    }
}

