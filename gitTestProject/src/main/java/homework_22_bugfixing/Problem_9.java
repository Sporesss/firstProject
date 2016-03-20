package homework_22_bugfixing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem_9 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.home"));
        File file = new File(path.toAbsolutePath() + "/test.txt");
        System.out.println(file.exists());

        if (!file.exists()) {
            file.createNewFile();
        }

        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            System.out.println(scan.next());
        }
        scan.close();
    }

}
