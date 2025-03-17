/* University.java ====================== */
/* ====================================== */
/* Лабораторна робота 1 ================= */
/* ІПЗ-1 2024-25 ======================== */
/* Колєснікова Вєроніка, Філюшкін Арсеній */

/**
 * Список факультетів
 */
class FacultyList {
    private Faculty[] faculties;
    private int count;

    public FacultyList() {
        faculties = new Faculty[8];
        count = 0;
    }

    /**
     * Додає факультет
     * @param faculty Об'єкт факультету
     * @return true, якщо факультет було додано, false, якщо факультет існує
     */
    public final boolean add(Faculty faculty) {
        for (int i = 0; i < count; ++i) {
            if (faculties[i].getName().equalsIgnoreCase(faculty.getName()))
                return false;
        }
        if (count == faculties.length) {
            Faculty[] reallocated = new Faculty[faculties.length * 2];
            for (int i = 0; i < count; ++i)
                reallocated[i] = faculties[i];
            faculties = reallocated;
        }
        faculties[count++] = faculty;
        return true;
    }

    /**
     * Видаляє факультет
     * @param index Індекс факультету
     */
    public final void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            faculties[i] = faculties[i + 1];
        --count;
    }

    /**
     * @param index Індекс факультету
     * @return Об'єкт факультету
     */
    public final Faculty get(int index) {
        return faculties[index % count];
    }

    /** @return Кількість */
    public final int getCount() {
        return count;
    }
}

/**
 * Список кафедр
 */
class DepartmentList {
    private Department[] departments;
    private int count;

    public DepartmentList() {
        departments = new Department[8];
        count = 0;
    }

    /**
     * Додає кафедру
     * @param department Об'єкт кафедри
     */
    public final void add(Department department) {
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

    /**
     * Видаляє кафедру
     * @param index Індекс кафедри
     */
    public final void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            departments[i] = departments[i + 1];
        --count;
    }

    /**
     * @param index Індекс кафедри
     * @return Об'єкт кафедри
     */
    public final Department get(int index) {
        return departments[index % count];
    }

    /** @return Кількість */
    public final int getCount() {
        return count;
    }
}

/**
 * Список викладачів
 */
class TeacherList {
    private Teacher[] teachers;
    private int count;

    public TeacherList() {
        teachers = new Teacher[8];
        count = 0;
    }

    /**
     * Додає викладача
     * @param teacher Об'єкт викладача
     */
    public final void add(Teacher teacher) {
        if (count == teachers.length) {
            Teacher[] reallocated = new Teacher[teachers.length * 2];
            for (int i = 0; i < count ; ++i)
                reallocated[i] = teachers[i];
            teachers = reallocated;
        }
        teachers[count++] = teacher;
    }

    /**
     * Видаляє викладача
     * @param index Індекс викладача
     */
    public final void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            teachers[i] = teachers[i + 1];
        --count;
    }

    /**
     * @param index Індекс викладача
     * @return Об'єкт викладача
     */
    public final Teacher get(int index) {
        return teachers[index % count];
    }

    /** @return Кількість */
    public final int getCount() {
        return count;
    }
}

/**
 * Список студентів
 */
class StudentList {
    private Student[] students;
    private int count;

    public StudentList() {
        students = new Student[8];
        count = 0;
    }

    /**
     * Додає студента
     * @param student Об'єкт студента
     */
    public void add(Student student) {
        if (count == students.length) {
            Student[] reallocated = new Student[students.length * 2];
            for (int i = 0; i < count ; ++i)
                reallocated[i] = students[i];
            students = reallocated;
        }
        students[count++] = student;
    }

    /**
     * Видаляє студента
     * @param index Індекс студента
     */
    public final void remove(int index) {
        index %= count;
        for (int i = index; i < count - 1; ++i)
            students[i] = students[i + 1];
        --count;
    }

    /**
     * @param index Індекс студента
     * @return Об'єкт студента
     */
    public final Student get(int index) {
        return students[index % count];
    }

    /** @return Кількість */
    public final int getCount() {
        return count;
    }
    Student[] student = new Student []{
    };

    public String toString() {
        return student.toString();
    }
}

/**
 * Університет
 */
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

    /**
     * Ініціалізує заготовлених студентів
     */
    public void initializeStudents(){
        this.addStudent("Петро", "Петренко", "Петрович", 0, 2, 1);
        this.addStudent("Доп", "Шкібіді", "Доп", 0, 3, 3);
        this.addStudent("Микола", "Науменко", "Васильович", 0, 1, 2);
        this.addStudent("Аліна", "Кротик", "Юріївна", 0, 1, 3);
        this.addStudent("Анатолій", "Чіпідейл", "Максимович", 0, 5, 1);
        this.addStudent("Станіслав", "Чорний", "Олегович", 0, 2, 2);
        this.addStudent("Марина", "Оріфлейм", "Андріївна", 0, 3, 1);
        this.addStudent("Ігор", "Іванюк", "Іванович", 0, 4, 3);
        this.addStudent("Лілія", "Дорошенко", "Богданівна", 0, 1, 1);
        this.addStudent("Микита", "Йолопенко", "Денисович", 0, 2, 4);
        this.addStudent("Степан", "Комарик", "Васильович", 0, 3, 2);
        this.addStudent("Ангеліна", "Лесик", "Назарівна", 0, 1, 3);
        this.addStudent("Олексій", "Харченко", "Павлович", 0, 2, 1);
        this.addStudent("Іван", "Геращенко", "Ігорович", 0, 5, 3);
        this.addStudent("Марина", "Поліщук", "Вікторівна", 0, 3, 1);
        this.addStudent("Олена", "Кравчук", "Михайлівна", 0, 4, 2);
        this.addStudent("Андрій", "Соловей", "Сергійович", 0, 5, 2);
        this.addStudent("Ольга", "Зозуля", "Андріївна", 0, 2, 1);
        this.addStudent("Денис", "Погорілий", "Петрович", 0, 1, 4);
        this.addStudent("Анна", "Дорошенко", "Олексіївна", 0, 2, 3);
        this.addStudent("Дмитро", "Кравченко", "Сергійович", 0, 4, 2);
        this.addStudent("Оксана", "Жук", "Михайлівна", 0, 3, 1);
        this.addStudent("Богдан", "Левченко", "Михайлович", 0, 2, 2);
        this.addStudent("Марина", "Іванчук", "Павлівна", 0, 5, 1);
        this.addStudent("Євгеній", "Савчук", "Іванович", 0, 1, 4);
        this.addStudent("Вадим", "Мельник", "Олександрович", 0, 3, 1);
        this.addStudent("Ірина", "Гончарук", "Сергіївна", 0, 2, 1);
        this.addStudent("Богдана", "Коваль", "Петрівна", 0, 6, 2);
        this.addStudent("Юрій", "Остапенко", "Анатолійович", 0, 4, 3);

    }

    /**
     * Ініціалізує заготовлених викладачів
     */
    public void initializeTeachers(){
        this.addTeacher("Михайло", "Бондаренко", "Сергійович", 1, "викладач математики");
        this.addTeacher("Юрій", "Тарасенко", "Володимирович", 0, "викладач фізики");
        this.addTeacher("Анна", "Лісова", "Олександрівна", 0, "викладачка алгоритмів і структур даних");
        this.addTeacher("Василь", "Грицай", "Павлович",1, "викладач математичного аналізу" );
        this.addTeacher("Ірина", "Петренко", "Вікторівна", 1, "викладачка лінійної алгебри");
        this.addTeacher("Денис", "Савченко", "Ігорович", 0, "викладач основ мережевих технологій");
        this.addTeacher("Катерина", "Шевченко", "Дмитрівна", 0, "викладачка МОПІ");
        this.addTeacher("Олександр", "Демченко", "Юрійович", 0, "викладач математичної логіки");
        this.addTeacher("Іван", "Наливайко", "Олексійович", 1, "викладач диференціальних рівнянь");
    }

    /**
     * Додає факультет до університету.
     * @param name Назва факультету, форматується.
     * @return true, якщо факультет був успішно доданий, false, якщо такий факультет вже існує і, відповідно, не був доданий.
     */
    public final boolean addFaculty(String name) {
        return faculties.add(new Faculty(name));
    }

    /**
     * Додає кафедру до факультету.
     * @param name Назва кафедри
     * @param faculty Індекс факультету, до якого належить кафедра
     */
    public final void addDepartment(String name, int faculty) {
        departments.add(new Department(name, faculty));
    }

    /**
     * Додає викладача до кафедри.
     * @param name Ім'я
     * @param surname Прізвище
     * @param pb По батькові
     * @param department Кафедра
     * @param position Посада
     */
    public final void addTeacher(String name, String surname, String pb, int department, String position) {
        teachers.add(new Teacher(name, surname, pb, department, position));
    }

    /**
     * Додає студента до кафедри.
     * @param name Ім'я
     * @param surname Прізвище
     * @param pb По батькові
     * @param department Кафедра
     * @param year Курс
     * @param group Група
     */
    public final void addStudent(String name, String surname, String pb, int department, int year, int group) {
        students.add(new Student(name, surname, pb, department, year, group));
    }

    /**
     * Перейменовує факультет
     * @param faculty Індекс факультета
     * @param name Назва факультета
     */
    public final void renameFaculty(int faculty, String name) {
       faculties.get(faculty).rename(name);
    }

    /**
     * Перейменовує кафедру
     * @param department Індекс кафедри
     * @param name Назва кафедри
     */
    public final void renameDepartment(int department, String name) {
        departments.get(department).rename(name);
    }

    /**
     * Змінює факультет кафедри
     * @param department Індекс кафедри
     * @param faculty Індекс факультету
     */
    public final void changeDepartmentFaculty(int department, int faculty) {
        departments.get(department).changeFaculty(faculty);
    }

    /**
     * Перейменовує студента
     * @param student Індекс студента
     * @param name Ім'я студента
     * @param surname Прізвище студента
     * @param pb По батькові студента
     */
    public final void renameStudent(int student, String name, String surname, String pb) {
        students.get(student).rename(name, surname, pb);
    }

    /**
     * Змінює кафедру студента
     * @param student Індекс студента
     * @param department Кафедра студента
     */
    public final void changeStudentDepartment(int student, int department) {
        students.get(student).changeDepartment(department);
    }

    /**
     * Змінює курс студента
     * @param student Індекс студента
     * @param year Курс студента
     */
    public final void changeStudentYear(int student, int year) {
        students.get(student).changeYear(year);
    }

    /**
     * Змінює групу студента
     * @param student Індекс студента
     * @param group Група студента
     */
    public final void changeStudentGroup(int student, int group) {
        students.get(student).changeGroup(group);
    }

    /**
     * Перейменовує викладача
     * @param teacher Індекс викладача
     * @param name Ім'я викладача
     * @param surname Прізвище викладача
     * @param pb По батькові викладача
     */
    public final void renameTeacher(int teacher, String name, String surname, String pb) {
        teachers.get(teacher).rename(name, surname, pb);
    }

    /**
     * Змінює кафедру викладача
     * @param teacher Індекс викладача
     * @param department Індекс кафедри
     */
    public final void changeTeacherDepartment(int teacher, int department) {
        teachers.get(teacher).changeDepartment(department);
    }

    /**
     * Змінює посаду викладача
     * @param teacher Індекс викладача
     * @param position Посада
     */
    public final void changeTeacherPosition(int teacher, String position) {
        teachers.get(teacher).changePosition(position);
    }

    /**
     * Видаляє факультет, разом із ним і кафедри, що до нього належать
     * @param faculty Індекс факультета
     */
    public final void removeFaculty(int faculty) {
        faculties.remove(faculty);
        for (int i = 0; i < departments.getCount(); ++i) {
            if (departments.get(i).getFaculty() == faculty)
                removeDepartment(i--);
        }
    }

    /**
     * Видаляє кафедру, разом із нею викладачів та студентів, що до неї належать
     * @param department Індекс кафедри
     */
    public final void removeDepartment(int department) {
        departments.remove(department);
        for (int i = 0; i < students.getCount(); ++i) {
            if (students.get(i).getDepartment() == department)
                fireStudent(i--);
        }
        for (int i = 0; i < teachers.getCount(); ++i) {
            if (teachers.get(i).getDepartment() == department)
                fireTeacher(i--);
        }
    }

    /**
     * Видаляє студента
     * @param student Індекс студента
     */
    public final void fireStudent(int student) {
        students.remove(student);
    }

    /**
     * Видаляє викладача
     * @param teacher Індекс викладача
     */
    public final void fireTeacher(int teacher) {
        teachers.remove(teacher);
    }

    /**
     * Шукає викладачів за іменем, в даному випадку за наявністю символів у ньому
     * @param query Пошуковий запит
     */
    public final String searchTeachersByName(String query) {
        int count = teachers.getCount();
        if (count == 0) return "";
        String result = "";
        for (int i = 0; i < count; ++i) {
            Teacher t = teachers.get(i);
            if (Utils.containsIgnoreCase(t.getFullName(), query))
                result += getTeacherInfo(t) + ((i == count - 1) ? "" : "\n");
        }
        return result;
    }

    /**
     * Шукає студентів за іменем, в даному випадку за наявністю символів у ньому
     * @param query Пошуковий запит
     */
    public final String searchStudentsByName(String query) {
        int count = students.getCount();
        if (count == 0) return "";
        String result = "";
        for (int i = 0; i < count; ++i) {
            Student s = students.get(i);
            if (Utils.containsIgnoreCase(s.getFullName(), query))
                result += getStudentInfo(s) + ((i == count - 1) ? "" : "\n");
        }
        return result;
    }

    /**
     * Шукає студентів за курсом
     * @param year Курс
     */
    public final String searchStudentsByYear(int year) {
        int count = students.getCount();
        if (count == 0) return "";
        String result = "";
        for (int i = 0; i < count; ++i) {
            Student s = students.get(i);
            if (s.getYear() == year)
                result += getStudentInfo(s) + ((i == count - 1) ? "" : "\n");
        }
        return result;
    }

    /**
     * Шукає студентів за групою
     * @param group Група
     */
    public final String searchStudentsByGroup(int group) {
        int count = students.getCount();
        if (count == 0) return "";
        String result = "";
        for (int i = 0; i < count; ++i) {
            Student s = students.get(i);
            if (s.getGroup() == group)
                result += getStudentInfo(s) + ((i == count - 1) ? "" : "\n");
        }
        return result;
    }

    /**
     * @return Відформатований String, що містить список студентів, відсортованих за курсом
     */
    public final String getSortedStudentsByYear() {
        int count = students.getCount();
        if (count == 0)
            return "";
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

    /**
     * @param faculty Факультет
     * @return Відформатований String, що містить список студентів на факультеті, відсортованих за алфавітом
     */
    public final String getSortedFacultyStudentsByAlphabet(int faculty) {
        int count = students.getCount();
        if (count == 0)
            return "";
        Student[] sorted = new Student[count];
        for (int i = 0, j = 0, len = count; i < len; ++i) {
            Student s = students.get(i);
            if (departments.get(s.getDepartment()).getFaculty() != faculty) {
                --count;
                continue;
            }
            sorted[j++] = students.get(i);
        }
        for (int i = 1; i < count; ++i) {
            Student student = sorted[i];
            int j;
            for (j = i - 1; j >= 0 && sorted[j].getFullName().compareToIgnoreCase(student.getFullName()) > 0; --j)
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

    /**
     * @param faculty Факультет
     * @return Відформатований String, що містить список викладачів на факультеті, відсортованих за алфавітом
     */
    public final String getSortedFacultyTeachersByAlphabet(int faculty) {
        int count = teachers.getCount();
        if (count == 0)
            return "";
        Teacher[] sorted = new Teacher[count];
        for (int i = 0, j = 0, len = count; i < len; ++i) {
            Teacher t = teachers.get(i);
            if (departments.get(t.getDepartment()).getFaculty() != faculty) {
                --count;
                continue;
            }
            sorted[j++] = teachers.get(i);
        }
        for (int i = 1; i < count; ++i) {
            Teacher teacher = sorted[i];
            int j;
            for (j = i - 1; j >= 0 && sorted[j].getFullName().compareToIgnoreCase(teacher.getFullName()) > 0; --j)
                sorted[j + 1] = sorted[j];
            sorted[j + 1] = teacher;
        }
        String result = "";
        for (int i = 0; i < count; ++i) {
            String info = getTeacherInfo(sorted[i]);
            if (i < count - 1)
                info += "\n";
            result += info;
        }
        return result;
    }

    /**
     * @param department Кафедра
     * @return Відформатований String, що містить список студентів на кафедрі, відсортованих за курсом
     */
    public final String getSortedDepartmentStudentsByYear(int department) {
        int count = students.getCount();
        if (count == 0)
            return "";
        Student[] sorted = new Student[count];
        for (int i = 0, j = 0, len = count; i < len; ++i) {
            Student s = students.get(i);
            if (s.getDepartment() != department) {
                --count;
                continue;
            }
            sorted[j++] = students.get(i);
        }
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

    /**
     * @param department Кафедра
     * @return Відформатований String, що містить список студентів на кафедрі, відсортованих за алфавітом
     */
    public final String getSortedDepartmentStudentsByAlphabet(int department) {
        int count = students.getCount();
        if (count == 0)
            return "";
        Student[] sorted = new Student[count];
        for (int i = 0, j = 0, len = count; i < len; ++i) {
            Student s = students.get(i);
            if (s.getDepartment() != department) {
                --count;
                continue;
            }
            sorted[j++] = students.get(i);
        }
        for (int i = 1; i < count; ++i) {
            Student student = sorted[i];
            int j;
            for (j = i - 1; j >= 0 && sorted[j].getFullName().compareToIgnoreCase(student.getFullName()) > 0; --j)
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

    /**
     * @param department Кафедра
     * @return Відформатований String, що містить список викладачів на кафедрі, відсортованих за алфавітом
     */
    public final String getSortedDepartmentTeachersByAlphabet(int department) {
        int count = teachers.getCount();
        if (count == 0)
            return "";
        Teacher[] sorted = new Teacher[count];
        for (int i = 0, j = 0, len = count; i < len; ++i) {
            Teacher t = teachers.get(i);
            if (t.getDepartment() != department) {
                --count;
                continue;
            }
            sorted[j++] = teachers.get(i);
        }
        for (int i = 1; i < count; ++i) {
            Teacher teacher = sorted[i];
            int j;
            for (j = i - 1; j >= 0 && sorted[j].getFullName().compareToIgnoreCase(teacher.getFullName()) > 0; --j)
                sorted[j + 1] = sorted[j];
            sorted[j + 1] = teacher;
        }
        String result = "";
        for (int i = 0; i < count; ++i) {
            String info = getTeacherInfo(sorted[i]);
            if (i < count - 1)
                info += "\n";
            result += info;
        }
        return result;
    }

    /**
     * @param department Кафедра
     * @param year Курс
     * @return Відформатований String, що містить список студентів на кафедрі певного курсу
     */
    public final String getDepartmentStudentsOfYear(int department, int year) {
        int count = students.getCount();
        if (count == 0)
            return "";
        Student[] sorted = new Student[count];
        for (int i = 0, j = 0, len = count; i < len; ++i) {
            Student s = students.get(i);
            if (s.getDepartment() != department || s.getYear() != year) {
                --count;
                continue;
            }
            sorted[j++] = students.get(i);
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

    /**
     * @param department Кафедра
     * @param year Курс
     * @return Відформатований String, що містить список студентів на кафедрі певного курсу за алфавітом
     */
    public final String getDepartmentStudentsOfYearByAlphabet(int department, int year) {
        int count = students.getCount();
        if (count == 0)
            return "";
        Student[] sorted = new Student[count];
        for (int i = 0, j = 0, len = count; i < len; ++i) {
            Student s = students.get(i);
            if (s.getDepartment() != department || s.getYear() != year) {
                --count;
                continue;
            }
            sorted[j++] = students.get(i);
        }
        for (int i = 1; i < count; ++i) {
            Student student = sorted[i];
            int j;
            for (j = i - 1; j >= 0 && sorted[j].getFullName().compareToIgnoreCase(student.getFullName()) > 0; --j)
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

    /** @return Кількість факультетів */
    public final int getFacultyCount() {
        return faculties.getCount();
    }

    /** @return Кількість кафедр */
    public final int getDepartmentCount() {
        return departments.getCount();
    }

    /** @return Кількість викладачів */
    public final int getTeacherCount() {
        return students.getCount();
    }

    /** @return Кількість студентів */
    public final int getStudentCount() {
        return students.getCount();
    }

    /**
     * @param index Індекс факультету
     * @return Назва факультету
     */
    public final String getFacultyName(int index) {
        return faculties.get(index).getName();
    }

    /**
     * @param index Індекс кафедри
     * @return Назва кафедри
     */
    public final String getDepartmentName(int index) {
        return departments.get(index).getName();
    }

    /**
     * @param index Індекс кафедри
     * @return Індекс факультету, до якого належить кафедра
     */
    public final int getDepartmentFaculty(int index) {
        return departments.get(index).getFaculty();
    }

    /**
     * @param index Індекс викладача
     * @return ПІБ викладача
     */
    public final String getTeacherName(int index) {
        return teachers.get(index).getFullName();
    }

    /**
     * @param index Індекс викладача
     * @return Кафедра викладача
     */
    public final int getTeacherDepartment(int index) {
        return teachers.get(index).getDepartment();
    }

    /**
     * @param index Індекс викладача
     * @return Факультет викладача
     */
    public final int getTeacherFaculty(int index) {
        return departments.get(teachers.get(index).getDepartment()).getFaculty();
    }

    /**
     * @param index Індекс викладача
     * @return Посада викладача
     */
    public final String getTeacherPosition(int index) {
        return teachers.get(index).getPosition();
    }

    /**
     * @param index Індекс студента
     * @return ПІБ студента
     */
    public final String getStudentName(int index) {
        return students.get(index).getFullName();
    }

    /**
     * @param index Індекс студента
     * @return Кафедра студента
     */
    public final int getStudentDepartment(int index) {
        return students.get(index).getDepartment();
    }

    /**
     * @param index Індекс студента
     * @return Факультет студента
     */
    public final int getStudentFaculty(int index) {
        return departments.get(students.get(index).getDepartment()).getFaculty();
    }

    /**
     * @param index Індекс студента
     * @return Курс студента
     */
    public final int getStudentYear(int index) {
        return students.get(index).getYear();
    }

    /**
     * @param index Індекс студента
     * @return Група студента
     */
    public final int getStudentGroup(int index) {
        return students.get(index).getGroup();
    }

    /**
     * @param teacher Об'єкт викладача
     * @return Повна інформація про викладача у текстовому вигляді
     */
    private String getTeacherInfo(Teacher teacher) {
        Department department = departments.get(teacher.getDepartment());
        Faculty faculty = faculties.get(department.getFaculty());
        return teacher.getFullName() + ", " + faculty.getName() + ", " + department.getName() + ": " + teacher.getPosition();
    }

    /**
     * @param student Об'єкт студента
     * @return Повна інформація про студента у текстовому вигляді
     */
    private String getStudentInfo(Student student) {
        Department department = departments.get(student.getDepartment());
        Faculty faculty = faculties.get(department.getFaculty());
        return student.getFullName() + ", " + faculty.getName() + ", " + department.getName() + ": " + student.getYear() + " курс, " + student.getGroup() + " група";
    }
}