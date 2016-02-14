package homework_13.EmployersWithRecursion;

import java.util.Arrays;

public class EmployerTest {

    public static final String EMP_1 = "emp1";
    public static final String EMP_2 = "emp2";
    public static final String EMP_3 = "emp3";

    public static void main(String[] args) {
        Employer bossArray[] = {
                new Employer("boss_1"),
                new Employer("boss_2"),
                new Employer("boss_3")
        };

        Employer emp3[] = {new Employer(EMP_3, bossArray)};
        Employer emp2[] = {new Employer(EMP_2, emp3)};
        Employer emp1[] = {new Employer(EMP_1, emp2)};

        Employer employers[] = new Employer[7];
        getAllEmployer(employers, 0, emp1);
        System.out.println(Arrays.toString(employers));
    }

    public static void getAllEmployer(Employer employer[], int currentPosition, Employer someArray[]) {
        for (Employer someEmployer : someArray) {
            employer[++currentPosition] = someEmployer;
            if (someEmployer.getBoss() != null) {
                getAllEmployer(employer, currentPosition, someEmployer.getBoss());
            }
        }
    }
}
