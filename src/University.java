class FacultyList {
    private Faculty[] faculties;
    private int count;

    public FacultyList() {
        faculties = new Faculty[8];
        count = 0;
    }

    public void add(Faculty faculty) {
        for (int i = 0; i < count; ++i) {
            if (faculties[i].getName().equalsIgnoreCase(faculty.getName()))
                return;
        }
        if (count == faculties.length) {
            Faculty[] reallocated = new Faculty[faculties.length * 2];
            for (int i = 0; i < count; ++i)
                reallocated[i] = faculties[i];
            faculties = reallocated;
        }
        faculties[count++] = faculty;
    }

    public void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            faculties[i] = faculties[i + 1];
        --count;
    }

    public Faculty get(int index) {
        return faculties[index % count];
    }

    public final int getCount() {
        return count;
    }
}

class DepartmentList {
    private Department[] departments;
    private int count;

    public DepartmentList() {
        departments = new Department[8];
        count = 0;
    }

    public void add(Department department) {
        for (int i = 0; i < count; ++i) {
            if (departments[i].getName().equalsIgnoreCase(department.getName()))
                return;
        }
        if (count == departments.length) {
            Department[] reallocated = new Department[departments.length * 2];
            for (int i = 0; i < count; ++i) {
                reallocated[i] = departments[i];
            }
            departments = reallocated;
        }
        departments[count++] = department;
    }

    public void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            departments[i] = departments[i + 1];
        --count;
    }

    public Department get(int index) {
        return departments[index % count];
    }

    public final int getCount() {
        return count;
    }
}

class TeacherList {
    private Teacher[] teachers;
    private int count;

    public TeacherList() {
        teachers = new Teacher[8];
        count = 0;
    }

    public void add(Teacher teacher) {
        if (count == teachers.length) {
            Teacher[] reallocated = new Teacher[teachers.length * 2];
            for (int i = 0; i < count - 1; ++i)
                reallocated[i] = teachers[i];
            teachers = reallocated;
        }
        teachers[count++] = teacher;
    }

    public void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            teachers[i] = teachers[i + 1];
        --count;
    }

    public Teacher get(int index) {
        return teachers[index % count];
    }

    public final int getCount() {
        return count;
    }
}

class StudentList {
    private Student[] students;
    private int count;

    public StudentList() {
        students = new Student[8];
        count = 0;
    }

    public void add(Student student) {
        if (count == students.length) {
            Student[] reallocated = new Student[students.length * 2];
            for (int i = 0; i < count - 1; ++i)
                reallocated[i] = students[i];
            students = reallocated;
        }
        students[count++] = student;
    }

    public void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            students[i] = students[i + 1];
        --count;
    }

    public Student get(int index) {
        return students[index % count];
    }

    public final int getCount() {
        return count;
    }
}

public class University {
    private final FacultyList faculties;
    private final DepartmentList departments;
    private final StudentList students;
    private final TeacherList teachers;

    public University() {
        faculties = new FacultyList();
        departments = new DepartmentList();
        students = new StudentList();
        teachers = new TeacherList();
    }

    public final String getSortedStudentsByYear() {
        int count = students.getCount();
        Student[] sorted = new Student[count];
        for (int i = 0; i < count; ++i)
            sorted[i] = students.get(i);
        for (int i = 1; i < count; ++i) {
            Student student = sorted[i];
            int j;
            for (j = i - 1; j >= 0 && sorted[j].getYear() > student.getYear(); --j)
                sorted[j + 1] = sorted[j];
            sorted[j + 1] = student;
        }
        String result = "";
        for (int i = 0; i < count; ++i) {
            String info = getStudentInfo(sorted[i]);
            if (i < count - 1)
                info += "\n";
            result += info;
        }
        return result;
    }

    private String getTeacherInfo(Teacher teacher) {
        Department department = departments.get(teacher.getDepartment());
        Faculty faculty = faculties.get(department.getFaculty());
        return teacher.getFullName() + ", " + faculty.getName() + ", " + department.getName() + ": " + teacher.getFullName();
    }

    private String getStudentInfo(Student student) {
        Department department = departments.get(student.getDepartment());
        Faculty faculty = faculties.get(department.getFaculty());
        return student.getFullName() + ", " + faculty.getName() + ", " + department.getName() + ": " + student.getYear() + " курс, " + student.getGroup() + " група";
    }
}