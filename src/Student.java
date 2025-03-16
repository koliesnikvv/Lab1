class Student extends Person {
    private int year;
    private int group;

    public Student(String name, String surname, String pb, int department, int year, int group) {
        super(name, surname, pb, department);
        this.year = year < 1 ? 1 : (year > 4 ? 4 : year);
        this.group = group < 1 ? 1 : group;
    }

    public final void changeYear(int year) {
        this.year = year < 1 ? 1 : (year > 4 ? 4 : year);
    }

    public final void changeGroup(int group) {
        this.group = group < 1 ? 1 : group;
    }

    public final int getYear() {
        return year;
    }

    public final int getGroup() {
        return group;
    }
}