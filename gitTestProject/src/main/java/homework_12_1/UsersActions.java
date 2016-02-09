package homework_12_1;

import java.util.ArrayList;
import java.util.Scanner;

public class UsersActions {
    ArrayList<String> arrayList = new ArrayList<String>();

    public UsersActions() {
        fillingDefaultArrayList();
    }

    void fillingDefaultArrayList() {
        arrayList.add("God");
        arrayList.add("Save");
        arrayList.add("the");
        arrayList.add("Queen");
    }

    void userReadData() {
        for (String arrayElement : arrayList) {
            System.out.print(arrayElement + " ");
        }
        System.out.println();
    }

    void userAddData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What you want to add? Enter it: ");
        arrayList.add(scanner.nextLine());
    }

    void userDeleteData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which one do you want to delete? Enter index: ");
        arrayList.remove(scanner.nextInt());
    }

    void userEraseAll() {
        arrayList.clear();
    }
}
