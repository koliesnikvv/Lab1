/* Person.java ========================== */
/* ====================================== */
/* Лабораторна робота 1 ================= */
/* ІПЗ-1 2024-25 ======================== */
/* Колєснікова Вєроніка, Філюшкін Арсеній */

/**
 * Особа
 */
class Person {
    private String name;
    private String surname;
    private String pb;
    private int department;

    /**
     * @param name Ім'я
     * @param surname Прізвище
     * @param pb По батькові
     * @param department Кафедра
     */
    public Person(String name, String surname, String pb, int department) {
        this.name = Utils.formatPersonName(name);
        this.surname = Utils.formatPersonName(surname);
        this.pb = Utils.formatPersonName(pb);
        this.department = department;
    }

    /**
     * Перейменовує особу
     * @param name Ім'я
     * @param surname Прізвище
     * @param pb По-батькові
     */
    public final void rename(String name, String surname, String pb) {
        this.name = Utils.formatPersonName(name);
        this.surname = Utils.formatPersonName(surname);
        this.pb = Utils.formatPersonName(pb);
    }

    /**
     * Змінює кафедру особи
     * @param department Кафедра
     */
    public final void changeDepartment(int department) {
        this.department = department;
    }

    /** @return Ім'я */
    public final String getName() {
        return name;
    }

    /** @return Прізвище */
    public final String getSurname() {
        return surname;
    }

    /** @return По батькові */
    public final String getPB() {
        return pb;
    }

    /** @return ПІБ */
    public final String getFullName() {
        return surname + " " + name + " " + pb;
    }

    /** @return Кафедра */
    public final int getDepartment() {
        return department;
    }
}
