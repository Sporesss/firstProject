package homework_13.EmployersWithRecursion;

public class Employer {

    private String name;
    private Employer boss[];

    public Employer(String name) {
        this.name = name;
    }

    public Employer(String name, Employer boss[]) {
        this.name = name;
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer[] getBoss() {
        return boss;
    }

    public void setBoss(Employer boss[]) {
        this.boss = boss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employer employer = (Employer) o;

        if (name != null ? !name.equals(employer.name) : employer.name != null) return false;
        return !(boss != null ? !boss.equals(employer.boss) : employer.boss != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (boss != null ? boss.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                //", boss=" + boss +
                '}';
    }
}
