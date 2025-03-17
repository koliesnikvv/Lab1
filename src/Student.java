/* Student.java ========================= */
/* ====================================== */
/* Лабораторна робота 1 ================= */
/* ІПЗ-1 2024-25 ======================== */
/* Колєснікова Вєроніка, Філюшкін Арсеній */

class Student extends Person {
    private int year;
    private int group;

    /**
     * @param name Ім'я
     * @param surname Прізвище
     * @param pb По батькові
     * @param department Кафедра
     * @param year Курс
     * @param group Група
     */
    public Student(String name, String surname, String pb, int department, int year, int group) {
        super(name, surname, pb, department);
        this.year = year;
        this.group = group;
    }

    /**
     * Змінює курс студента
     * @param year Курс
     */
    public final void changeYear(int year) {
        this.year = year;
    }

    /**
     * Змінює групу студента
     * @param group Група
     */
    public final void changeGroup(int group) {
        this.group = group;
    }

    /** @return Курс */
    public final int getYear() {
        return year;
    }

    /** @return Група */
    public final int getGroup() {
        return group;
    }

    public String toString() {
        return getFullName() + ", " + year + ", " + group;
    }
}