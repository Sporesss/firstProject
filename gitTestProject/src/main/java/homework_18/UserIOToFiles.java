package homework_18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class UserIOToFiles {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserIOToFiles userIOToFiles = new UserIOToFiles();

        Path pathToFile = Paths.get("C:\\JavaCourse");

        ArrayList<String> arrayListOfParameters = userIOToFiles.getParametersFromFile(pathToFile);
        ArrayList<String> listOfValues = userIOToFiles.getValuesOfParametersFromPropertiesFile(arrayListOfParameters);
        userIOToFiles.writeValuesToFile(listOfValues);
    }

    public ArrayList<String> getParametersFromFile(Path pathToFile) throws IOException, ClassNotFoundException {
        File file = new File(pathToFile + "/parameters.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<String> arrayListOfParameters = new ArrayList();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            arrayListOfParameters.add(line);
        }
        return arrayListOfParameters;
    }

    public ArrayList<String> getValuesOfParametersFromPropertiesFile(ArrayList<String> arrayListOfParameters) throws IOException {
        ArrayList<String> listOfValues = new ArrayList();

        Properties properties = new Properties();
        InputStream resourseAsStream = UserIOToFiles.class.getClassLoader().getResourceAsStream("homework_18.properties");
        properties.load(resourseAsStream);
        for (String parameter : arrayListOfParameters) {
            if ((properties.get(parameter)) != null) {
                System.out.println(parameter + " = " + properties.get(parameter));
            } else {
                System.out.println("Parameter -> " + "'" + parameter + "'" + " not available.");
            }
            listOfValues.add(parameter + " = " + properties.get(parameter));
        }
        return listOfValues;
    }

    public void writeValuesToFile(ArrayList<String> listOfValues) throws IOException {
        Path pathToNewFile = Paths.get("C:\\JavaCourse");
        File newFile = new File(pathToNewFile + "/" + System.getProperty("user.name") + ".txt");

//        FileWriter writer = new FileWriter(newFile, true);
//        for (String parameterAndValue : listOfValues) {
//            writer.write(parameterAndValue + System.getProperty("line.separator"));
//        }
//        writer.flush();
//        writer.close();

        PrintWriter pw = new PrintWriter(new FileWriter(newFile, true));
        for (String parameterAndValue : listOfValues) {
            pw.write(parameterAndValue);
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}
