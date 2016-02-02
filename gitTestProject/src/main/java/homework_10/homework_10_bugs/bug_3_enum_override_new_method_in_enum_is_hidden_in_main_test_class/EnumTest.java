package homework_10.homework_10_bugs.bug_3_enum_override_new_method_in_enum_is_hidden_in_main_test_class;

public class EnumTest {
    public static void main(String[] args) {
        TestEnum[] values = TestEnum.values();

        for (TestEnum testEnum : values) {
            testEnum.printVeryImportantInformation(); //IT WORKS
        }
    }
}
