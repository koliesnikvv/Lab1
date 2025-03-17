/* Teacher.java ========================= */
/* ====================================== */
/* Лабораторна робота 1 ================= */
/* ІПЗ-1 2024-25 ======================== */
/* Колєснікова Вєроніка, Філюшкін Арсеній */

class Teacher extends Person {
    private String position;

    /**
     * @param name Ім'я
     * @param surname Прізвище
     * @param pb По батькові
     * @param department Кафедра
     * @param position Посада
     */
    public Teacher(String name, String surname, String pb, int department, String position) {
        super(name, surname, pb, department);
        this.position = Utils.formatEntityName(position);
    }

    /**
     * Змінює посаду викладачу
     * @param position Посада
     */
    public final void changePosition(String position) {
        this.position = Utils.formatEntityName(position);
    }

    /** @return Посада */
    public final String getPosition() {
        return position;
    }
}
