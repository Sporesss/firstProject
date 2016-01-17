package homework_7.bug_3;

public class ChangesDoNotApplyForIntegerValueFromMethod {
    private Integer value = 1;

    public Integer getValue() {
        return value;
    }

    public Integer changeVal(Integer someValue) {  //the method changed
        value = new Integer(someValue);
        return value;
    }

    public static void main(String args[]) {
        Integer a = new Integer(2222);
        System.out.println(a);
        ChangesDoNotApplyForIntegerValueFromMethod c = new ChangesDoNotApplyForIntegerValueFromMethod();
        System.out.println(c.getValue());//get value before changes
        c.changeVal(a);//change c from 1 -> a -> must be 2222
        System.out.print("a == c.getValue() ? " + (a.equals(c.getValue()) ? "true" : "false"));//should be "true"; used 'equals' instead '=='
    }
}
