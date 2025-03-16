//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        University uni = new University();
        uni.addFaculty("Факультет інформатики");
        uni.addDepartment("Кафедра ІПЗ", 0);
        uni.addStudent("Лариса","Косач-Квітка", "Петрівна", 0, 2, 1);
        uni.addStudent("Арсенія","Грицька", "Сатанівна", 0, 2, 1);
        uni.addStudent("Арсеній","Філюшкін", "Павлович", 0, 1, 1);
        System.out.println(uni.getSortedDepartmentTeachersByAlphabet(0));
        System.out.println(uni.searchStudentsByName("а"));
    }
}