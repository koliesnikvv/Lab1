//кафедра

public class Department {
    private String name;
    private int faculty;

    public Department(String name, int faculty) {
        this.name = Utils.formatEntityName(name);
        this.faculty = faculty;
    }

    public final void rename(String name) {
        this.name = Utils.formatEntityName(name);
    }

    public final void changeFaculty(int faculty) {
        this.faculty = faculty;
    }

    public final String getName() {
        return name;
    }

    public final int getFaculty() {
        return faculty;
    }
}
