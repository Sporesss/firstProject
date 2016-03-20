package homework_22_bugfixing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Problem_8 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\JavaCourse\\firstProject\\gitTestProject\\src\\main\\resources");
        String fileName = "Problem_8.properties";
        String parameterForSearch = "username";
        String valueOfParameterForSearch = "admin";
        File file = new File(path.toAbsolutePath() + "/" + fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.write(parameterForSearch + " = " + valueOfParameterForSearch);
        writer.flush();
        writer.println();
        writer.close();

        InputStream fileInputStream = Problem_8.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        System.out.println(properties.get(parameterForSearch));
    }
}
