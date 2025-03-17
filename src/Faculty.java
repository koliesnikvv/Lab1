/* Faculty.java ========================= */
/* ====================================== */
/* Лабораторна робота 1 ================= */
/* ІПЗ-1 2024-25 ======================== */
/* Колєснікова Вєроніка, Філюшкін Арсеній */

/**
 * Факультет
 */
public class Faculty {
    private String name;

    /**
     * @param name Назва
     */
    public Faculty(String name) {
        this.name = Utils.formatEntityName(name);
    }

    /**
     * Перейменовує факультет
     * @param name Назва
     */
    public final void rename(String name) {
        this.name = Utils.formatEntityName(name);
    }

    /** @return Назва */
    public final String getName() {
        return name;
    }

}