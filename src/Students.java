class Students extends Human {
    private String group;
    private int course;



    public Students(String name, String surname, String pb, int course, String group) {
        super(name, surname, pb);
        this.course = course;
        this.group = group;
    }
    public String getGroup() {
        return group;
    }
    public int getCourse() {
        return course;
    }

}