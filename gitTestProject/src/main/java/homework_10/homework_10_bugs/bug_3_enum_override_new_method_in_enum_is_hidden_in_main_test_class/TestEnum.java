package homework_10.homework_10_bugs.bug_3_enum_override_new_method_in_enum_is_hidden_in_main_test_class;

public enum TestEnum {
    N1 {
        @Override
        public String toString() { return "new string view for N2 looks like -> )"; }
    },
    N2 {
        @Override
        public String toString() {
            return "new string view for N2 looks like -> )";
        }
    };

    public void printVeryImportantInformation() {    // was fixed
        System.out.println("very important information - for TestEnum child inner static class -> N2");
    }

    TestEnum() {
        System.out.println("constructor in enum -> by default");
    }


}
