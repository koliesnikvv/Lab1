class Student extends Person {
    private int year;
    private int group;

    public Student(String name, String surname, String pb, int department, int year, int group) {
        super(name, surname, pb, department);
        this.year = year;
        this.group = group;
    }

    public final void changeYear(int year) {
        this.year = year;
    }

    public final void changeGroup(int group) {
        this.group = group;
    }

    public final int getYear() {
        return year;
    }

    public final int getGroup() {
        return group;
    }
}