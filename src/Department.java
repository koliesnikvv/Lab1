//кафедра

class Department {
    String nameOfDepartment;

    public Department(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }
    public String getNameOfDepartment() {
        return nameOfDepartment;
    }
    public void addTeacher(Teacher teacher){
        teacher.add(teacher);
    }
}
