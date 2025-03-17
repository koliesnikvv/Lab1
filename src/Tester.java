import java.io.IOException;

public class Tester {
    public static void main(String[] args){
//        University university = new University();
//        university.addFaculty("Факультет Інформатики");
//        university.addDepartment("Кафедра ІПЗ", 0);
//        university.addDepartment("Кафедра КН", 0);
//        university.addingStudent();
        welcomes();


    }

    private static void welcomes() {
        System.out.println("Вітаємо в нашому університеті! Дозвольте запропонувати Вам переглянути наші факультети, кафедри, студентів та викладачів.");
        while (true) {
            try {
                System.out.println("З чим Ви хотіли б ознайомитись? Натисніть 1, аби працювати з наявними даними, натисніть 2, аби створити об'єкт власноруч: ");
                int currentOrNew = DataInput.getInt(null);
                switch (currentOrNew) {
                    case 1:
                        currentInfo();
                        break;
                    case 2:
                        creatingNewObj();
                        break;
                    default:
                        System.out.println("Будь ласка, введіть коректне значення!");
                        break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static void creatingNewObj() throws IOException {
        System.out.println("Створімо новий об'єкт для нашого університету!");
        System.out.println("Будь ласка, оберіть, що саме Ви хочете створити");
        while (true) {
            System.out.println("Для створення факультету натисніть 1; для кафедри натисніть 2; для викладачів натисніть 3; для студентів натисніть 4, щоб припинити створення натисніть 0:");
            int newObj = DataInput.getInt(null);
            switch (newObj) {
                case 1:
                    creatFuc();
                    break;
                case 2:
                    createDep();
                    break;
                case 3:
                    createTeacher();
                    break;
                case 4:
                    createStud();
                    break;
                default:
                    System.out.println("Будь ласка, введіть коректне значення!");
                    continue;
                case 0:
                    return;
            }
        }
    }



    private static void currentInfo() {
        System.out.println("Чудовий вибір! У нас є вже готові факультети, кафедри, виклаадчі та студенти!");
        System.out.println("Будь ласка, оберіть, з чим Ви хочете ознайомитись:");
        while (true) {
            System.out.println("Щоб працювати з факультетами, натисніть 1; для кафедр натисніть 2; для викладачів натисніть 3; для студентів натисніть 4 (щоб вийти натисніть 0):");
            int whichObj = DataInput.getInt(null);
            switch (whichObj) {
                case 1 -> facultySort(new University());
                case 2 -> departmentSort(new University());
                case 3 -> teachersSort(new University());
                case 4 -> studSort(new University());
                default -> System.out.println("Будь ласка, введіть коректне значення!");
                case 0 -> {
                    return;
                }

            }
        }
    }

    private static void facultySort(University university) {
        System.out.println("Оберіть, що Ви хочете робити з факультетом: 1 - вивести студентів за алфавітом по факультету, 2 - вивести викладачів за алфавітом по факультету: ");
        int chooseForFuc = DataInput.getInt(null);
        switch (chooseForFuc){
            case 1 -> {
                university = new University();
                university.addFaculty("Факультет Інформатики");
                university.addDepartment("Кафедра ІПЗ", 0);
                university.addDepartment("Кафедра КН", 0);
                university.addingStudent();
                System.out.println("Студенти, відсортовані по алфавіту за факультетом:");
                String students = university.getSortedFacultyStudentsByAlphabet(0);
              System.out.println(students);
            }
            case 2 -> {
                university = new University();
                university.addDepartment("Кафедра ІПЗ", 0);
                university.addDepartment("Кафедра КН", 0);
                university.addingTeacher();
                System.out.println("Викладачі, відсортовані за алфавіом по факультету: ");
                String teachers = university.getSortedFacultyTeachersByAlphabet(0);
                System.out.println(teachers);
            }

        }
    }
    private static void departmentSort(University university) {
        System.out.println("Оберіть, що саме Ви хочете робити з кафедрами: 1 - вивести студентів кафедри за курсами, 2 - вивести студентів кафедри за алфавітом, 3 - вивести студентів кафедри конкретного курсу, 4 - вивести викладачів за алфавітом по кафедрі: ");
        int chooseForDep = DataInput.getInt(null);
        switch (chooseForDep){
            case 1 -> {
                university = new University();
                university.addFaculty("Факультет Інформатики");
                university.addDepartment("Кафедра ІПЗ", 0);
                university.addDepartment("Кафедра КН", 0);
                university.addingStudent();
                System.out.println("Студенти кафедри, посортовані за курсами: ");
                String students = university.getSortedDepartmentStudentsByYear(0);
                System.out.println(students);
            }
            case 2 -> {
                university = new University();
                university.addFaculty("Факультет Інформатики");
                university.addDepartment("Кафедра ІПЗ", 0);
                university.addDepartment("Кафедра КН", 0);
                university.addingStudent();
                System.out.println("Студенти кафедри, посортовані за алфавітом: ");
                String students = university.getSortedDepartmentStudentsByAlphabet(0);
                System.out.println(students);

            }
            case 3 -> {
                while(true) {
                    System.out.println("Введіть номер курсу, який хочете вивести: ");
                    int courseNum = DataInput.getInt(null);
                    if (courseNum <= 0) {
                        System.out.println("Введіть коректне значення!");
                        continue;
                    }
                    university = new University();
                    university.addFaculty("Факультет Інформатики");
                    university.addDepartment("Кафедра ІПЗ", 0);
                    university.addDepartment("Кафедра КН", 0);
                    university.addingStudent();
                    System.out.println("Студенти кафедри, що навчаються на конкретному курсі: ");
                    String students = university.getDepartmentStudentsOfYear(0, courseNum);
                    System.out.println(students);
                }
            }
            case 4 -> {
                university = new University();
                university.addFaculty("Факультет Інформатики");
                university.addDepartment("Кафедра ІПЗ", 0);
                university.addDepartment("Кафедра КН", 0);
                university.addingTeacher();
                System.out.println("Викладачі кафедри, відсортовані за алфавітом: ");
                String teacher = university.getSortedDepartmentTeachersByAlphabet(0);
                System.out.println(teacher);
            }
        }

    }
private static void teachersSort(University university) {
    System.out.println("Оберіть, що саме Ви хочете робити з викладачами: 1 - знайти викладача за ПІБ, 2 - вивести викладачів за алфавітом по факультету, 3 - вивести викладачів за алфавітом по кафедрі: ");
    int chooseTeacherSort = DataInput.getInt(null);
    switch (chooseTeacherSort) {
//        case 1 -> ;
        case 2 -> {
            university = new University();
            university.addFaculty("Факультет Інформатики");
            university.addDepartment("Кафедра ІПЗ", 0);
            university.addDepartment("Кафедра КН", 0);
            university.addingTeacher();
            System.out.println("Викладачі факультету, відсортовані за алфавітом: ");
            String teachers = university.getSortedFacultyTeachersByAlphabet(0);
            System.out.println(teachers);
        }
        case 3 -> {
            university = new University();
            university.addFaculty("Факультет Інформатики");
            university.addDepartment("Кафедра ІПЗ", 0);
            university.addDepartment("Кафедра КН", 0);
            university.addingTeacher();
            System.out.println("Викладачі кафедри, відсортовані за алфавітом: ");
            String teacher = university.getSortedDepartmentTeachersByAlphabet(0);
            System.out.println(teacher);
        }
            default -> System.out.println("Введіть коректне значення!");
    }

}
private static void studSort(University university) {
        System.out.println("Оберіть, що саме Ви хочете робити зі студентами: 1 - знайти студента за ПІБ, 2 - знайти студента за групою, 3 - знайти студента за курсом, 4 - вивести всіх студентів, упорядкованих за курсами, 5 - вивести студентів, упорядкованих по алфавіту, 6 - вивесnи студентів кафедри за курсами, 7 - вивести студентів кафедри за алфавітом, 8 - вивести всіх студентів конкретного курсу, 9 - вивести студентів кафедри конкретного курсу: ");
        int chooseStudSorting= DataInput.getInt(null);
        switch (chooseStudSorting) {
//            case 1 -> {
//                System.out.println("Введіть ПІБ студента, якого шукаєте: ");
//
//                uni();
//                System.out.println("Знаходження студента за прізвищем, іменем або по батькові: ");
//                String students = university.searchStudentsByName(null);
//                System.out.println(students);
//            }
//            case 2 -> ;
//            case 3 -> ;
            case 4 -> {
                uni(university);
                System.out.println("Усі студенти, упорядковані за курсами: ");
                String students = university.getSortedStudentsByYear();
                System.out.println(students);
            }
            case 5 -> {
                uni(university);
                System.out.println("Усі студенти, посортовані по алфавіту: ");
                String students = university.getSortedFacultyStudentsByAlphabet(0);
                System.out.println(students);
            }
            case 6 -> {
                uni(university);
                System.out.println("Студенти кафедри, впорядковані за курсами: ");
                String students = university.getSortedDepartmentStudentsByYear(0);
                System.out.println(students);
            }
            case 7 -> {
                uni(university);
                System.out.println("Студенти кафедри, впорядковані за алфавітом: ");
                String students = university.getSortedDepartmentStudentsByAlphabet(0);
                System.out.println(students);
            }
//            case 8 -> ;
            case 9 -> {
                while(true) {
                    System.out.println("Введіть номер курсу, який хочете вивести: ");
                    int courseNum = DataInput.getInt(null);
                    if (courseNum <= 0) {
                        System.out.println("Введіть коректне значення!");
                        continue;
                    }
                    uni(university);
                    System.out.println("Студенти кафедри, що навчаються на конкретному курсі: ");
                    String students = university.getDepartmentStudentsOfYear(0, courseNum);
                    System.out.println(students);
                }
            }
        }
}



    private static void creatFuc() {
        String department;
        System.out.println("Ви можете створити власний факультет! ");
        System.out.println("Введіть назву для свого факультету: ");
        String faculty = null;
        try {
            faculty = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Назву додано!");
        System.out.println(faculty);
        while (true) {
            System.out.println("Додайте кафедру: ");
            try {
                System.out.println("Введіть назву кафедри: ");
                String dep =department = DataInput.getString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Назву додано!");
            System.out.println(department);
            System.out.println("Бажаєте додати ще кафедру? 1, якщо так: ");
            int oneMore = DataInput.getInt(null);
            if (oneMore != 1) {
                System.out.println("Ваш новий факультет " + faculty + " та кафедра " + department);
                break;
            }
            else{
                System.out.println("Введіть назву кафедри: ");
                String department2 = null;
                try {
                    department2 = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Назву додано!");
                System.out.println(department2);
                System.out.println("Ваш новий факультет " + faculty + " та кафедри " + department + ", " + department2);


            }
//            System.out.println("Бажаєте додати викладачів або студентів?");
//            int choice = DataInput.getInt(null);
//            if (choice == 1) {
//                System.out.println("Введіть кількість викладачів: ");
//                int teacherNum = DataInput.getInt(null);
//                for (int i = 0; i < teacherNum; i++) {
//                    System.out.println("Введіть ПІБ викладача: ");
//                    try {
//                        String newT = DataInput.getString();
//                        teachers[i] = new Teacher(newT);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("Ваші викладачі: ");
//
//                }
//
//            }
//            else {
//                break;
//            }
            break;
        }
    }

    private static void createDep() {
        String department = null;
        System.out.println("Ви можете створити власну кафедру! ");
        System.out.println("Введіть назву для своєї кафедри: ");
        try {
            department = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Назву додано!");
        System.out.println(department);
        while (true) {
            System.out.println("Бажаєте додати ще кафедру? 1, якщо так: ");
            int oneMore = DataInput.getInt(null);
            if (oneMore != 1) {
                System.out.println("Ваша нова кафедра " + department);
                break;
            } else {
                System.out.println("Введіть назву кафедри: ");
                String department2 = null;
                try {
                    department2 = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Назву додано!");
                System.out.println(department2);
                System.out.println("Ваша нова кафедра "  + department + " і кафедра " + department2);
                break;
            }
        }
    }
    private static void createTeacher(){

    }
    private static void createStud(){

    }

    private static void uni(University university){
        university = new University();
        university.addFaculty("Факультет Інформатики");
        university.addDepartment("Кафедра ІПЗ", 0);
        university.addDepartment("Кафедра КН", 0);
        university.addingStudent();
    }


}
