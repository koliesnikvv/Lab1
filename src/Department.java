/* Department.java ====================== */
/* ====================================== */
/* Лабораторна робота 1 ================= */
/* ІПЗ-1 2024-25 ======================== */
/* Колєснікова Вєроніка, Філюшкін Арсеній */

/**
 * Кафедра
 */
public class Department {
    private String name;
    private int faculty;

    /**
     * @param name Назва
     * @param faculty Факультет, до якого належить
     */
    public Department(String name, int faculty) {
        this.name = Utils.formatEntityName(name);
        this.faculty = faculty;
    }

    /**
     * Перейменовує кафедру
     * @param name Назва
     */
    public final void rename(String name) {
        this.name = Utils.formatEntityName(name);
    }

    /**
     * Змінює факультет
     * @param faculty Новий факультет
     */
    public final void changeFaculty(int faculty) {
        this.faculty = faculty;
    }

    /** @return Назва */
    public final String getName() {
        return name;
    }

    /** @return Факультет, до якого належить */
    public final int getFaculty() {
        return faculty;
    }
}
