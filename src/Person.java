abstract class Person {
    private String name;
    private String surname;
    private String pb;
    private int department;

    public Person(String name, String surname, String pb, int department) {
        this.name = Utils.formatPersonName(name);
        this.surname = Utils.formatPersonName(surname);
        this.pb = Utils.formatPersonName(pb);
        this.department = department;
    }

    public final void rename(String name, String surname, String pb) {
        this.name = Utils.formatPersonName(name);
        this.surname = Utils.formatPersonName(surname);
        this.pb = Utils.formatPersonName(pb);
    }

    public final void changeDepartment(int department) {
        this.department = department;
    }

    public final String getName() {
        return name;
    }

    public final String getSurname() {
        return surname;
    }

    public final String getPB() {
        return pb;
    }

    public final String getFullName() {
        return surname + " " + name + " " + pb;
    }

    public final int getDepartment() {
        return department;
    }
}
