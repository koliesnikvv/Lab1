abstract class Human {
    private String name;
    private String surname;
    private String pb;


    public Human(String name, String surname, String pb) {
        this.name = name;
        this.surname = surname;
        this.pb = pb;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPb() {
        return pb;
    }


//    public abstract void add(Teacher teacher);
//    public abstract void add(Students students);
}
