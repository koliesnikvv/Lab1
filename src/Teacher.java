class Teacher extends Person {
    private String position;

    public Teacher(String name, String surname, String pb, int department, String position) {
        super(name, surname, pb, department);
        this.position = Utils.formatEntityName(position);
    }

    public final void changePosition(String position) {
        this.position = Utils.formatEntityName(position);
    }

    public final String getPosition() {
        return position;
    }
}
