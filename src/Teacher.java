class Teacher extends Human {
    private String position;


    public Teacher(String name, String surname, String pb, String position) {
        super(name, surname, pb);
        this.position = position;

    }
    public String getPosition() {
        return position;
    }
    
}
