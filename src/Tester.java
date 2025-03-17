/* Tester.java ========================== */
/* ====================================== */
/* Лабораторна робота 1 ================= */
/* ІПЗ-1 2024-25 ======================== */
/* Колєснікова Вєроніка, Філюшкін Арсеній */

import java.io.IOException;

/**
 * Тестер.
 */
public class Tester {
    public University university;

    public static void main(String[] args) {
        new Tester().run();
    }

    private Tester() {
        university = new University();
    }

    /**
     * Запускає роботу програми
     */
    private void run() {
        welcomes();
    }

    /**
     * Привітання
     */
    private void welcomes() {
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


    /**
     * Створення об'єкта
     */
    private void creatingNewObj() throws IOException {
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

    /**
     * Створення об'єкта
     */
    private void currentInfo() {
        university.addFaculty("Факультет Інформатики");
        university.addDepartment("Кафедра ІПЗ", 0);
        university.addDepartment("Кафедра КН", 0);
        university.initializeStudents();
        university.initializeTeachers();
        System.out.println("Чудовий вибір! У нас є вже готові факультети, кафедри, виклаадчі та студенти!");
        System.out.println("Будь ласка, оберіть, з чим Ви хочете ознайомитись:");
        while (true) {
            System.out.println("Щоб працювати з факультетами, натисніть 1; для кафедр натисніть 2; для викладачів натисніть 3; для студентів натисніть 4 (щоб вийти натисніть 0):");
            int whichObj = DataInput.getInt(null);
            switch (whichObj) {
                case 1 -> facultySort();
                case 2 -> departmentSort();
                case 3 -> teachersSort(new University());
                case 4 -> studSort(new University());
                default -> System.out.println("Будь ласка, введіть коректне значення!");
                case 0 -> {
                    return;
                }
            }
        }
    }

    /**
     * Сортування за факультетами
     */
    private void facultySort() {
        System.out.println("Оберіть, що Ви хочете робити з факультетом: 1 - вивести студентів за алфавітом по факультету, 2 - вивести викладачів за алфавітом по факультету, 3 - редагувати факультет, 4 - додати факультет, 5 - видалити факультет: ");
        int chooseForFuc = DataInput.getInt(null);
        switch (chooseForFuc){
            case 1 -> {
                System.out.println("Студенти, відсортовані по алфавіту за факультетом:");
                String students = university.getSortedFacultyStudentsByAlphabet(0);
              System.out.println(students);
            }
            case 2 -> {
                university.initializeTeachers();
                System.out.println("Викладачі, відсортовані за алфавіом по факультету: ");
                String teachers = university.getSortedFacultyTeachersByAlphabet(0);
                System.out.println(teachers);
            }
            case 3 -> {
                System.out.println("Змініть ім'я наявного факультету");
                System.out.println("Введіть нову назву факультету: ");
                String newName;
                try {
                    newName = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String formattedName = Utils.formatEntityName(newName);
                System.out.println("Нова назва факультету - " + formattedName);
            }
            case 4 -> {
                creatFuc();
            }
            case 5 -> {
                university.removeFaculty(0);
                System.out.println("Факультет видалено!");
            }

        }
    }

    /**
     * Сортування за кафедрами
     */
    private void departmentSort() {
        System.out.println("Оберіть, що саме Ви хочете робити з кафедрами: 1 - вивести студентів кафедри за курсами, 2 - вивести студентів кафедри за алфавітом, 3 - вивести студентів кафедри конкретного курсу, 4 - вивести викладачів за алфавітом по кафедрі, 5 - змінити ім'я кафедри, 6 - додати нову кафедру, 7 - видалити наявну кафедру: ");
        int chooseForDep = DataInput.getInt(null);
        switch (chooseForDep){
            case 1 -> {
                System.out.println("Студенти кафедри, посортовані за курсами: ");
                String students = university.getSortedDepartmentStudentsByYear(0);
                System.out.println(students);
            }
            case 2 -> {
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
                    System.out.println("Студенти кафедри, що навчаються на конкретному курсі: ");
                    String students = university.getDepartmentStudentsOfYear(0, courseNum);
                    System.out.println(students);
                }
            }
            case 4 -> {
                System.out.println("Викладачі кафедри, відсортовані за алфавітом: ");
                String teacher = university.getSortedDepartmentTeachersByAlphabet(0);
                System.out.println(teacher);
            }
            case 5 -> {
                System.out.println("Змініть ім'я наявної кафедри");
                System.out.println("Введіть нову назву кафедри: ");
                String newName;
                try {
                    newName = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String formattedName = Utils.formatEntityName(newName);
                System.out.println("Нова назва кафедри - " + formattedName);
            }
            case 6 -> {
                createDep();
            }
            case 7 -> {
                university.removeDepartment(0);
                System.out.println("Кафедру видалено!");
            }
        }

    }

    /**
     * Сортування за викладачами
     */
    private void teachersSort(University university) {
        System.out.println("Оберіть, що саме Ви хочете робити з викладачами: 1 - знайти викладача за ПІБ, 2 - вивести викладачів за алфавітом по факультету, 3 - вивести викладачів за алфавітом по кафедрі, 4 - редагувати викладача, 5 - додати викладача, 6 - видалити викладача: ");
        int chooseTeacherSort = DataInput.getInt(null);
        switch (chooseTeacherSort) {
            case 1 -> {
                System.out.println("Введіть ПІБ викладача, якого бажаєте знайти: ");
                String teachers = null;
                try {
                    teachers = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String yourTeacher = university.searchTeachersByName(teachers);
                System.out.println("Шуканий викладач: ");

                System.out.println(yourTeacher);

            }
            case 2 -> {
                System.out.println("Викладачі факультету, відсортовані за алфавітом: ");
                String teachers = university.getSortedFacultyTeachersByAlphabet(0);
                System.out.println(teachers);
            }
            case 3 -> {
                System.out.println("Викладачі кафедри, відсортовані за алфавітом: ");
                String teacher = university.getSortedDepartmentTeachersByAlphabet(0);
                System.out.println(teacher);
            }
            case 4 -> {
                System.out.println("Якого викладача Ви плануєте змінити? Введіть ПІБ: ");
                String teacher = null;
                try {
                    teacher = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String chosenTeacher = university.searchTeachersByName(teacher);
                System.out.println("Будемо змінювати викладача " + chosenTeacher);
                    editTeacher();
                }

            case 5 -> {
                createTeacher();
            }
            case 6 -> {
                System.out.println("Введіть ПІБ викладача, якого хочете видалити: ");
                try {
                    String teacher = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Викладача видалено!");
            }
                default -> System.out.println("Введіть коректне значення!");
        }

    }

    /**
     * Редагування викладача
     */
    private static void editTeacher() {
        String name;
        String surname;
        String pb;
        String newPosition;
        String department;
        System.out.println("Введіть нове ім'я викладача: ");
        try {
            name = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String formattedName = Utils.formatPersonName(name);
        System.out.println("Введіть нове прізвище викладача: ");
        try {
            surname = DataInput.getString();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        String formattedSurName = Utils.formatPersonName(surname);
            System.out.println("Введіть нове по батькові викладача: ");
        try {
            pb = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String formattedPb = Utils.formatPersonName(pb);
        System.out.println("Введіть нову посаду викладача: ");
        try {
            newPosition = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String formattedPosition = newPosition;
        System.out.println("Введіть нову кафедру викладача: ");
        try {
            department = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String formattedDep = department;
        
        System.out.println("Змінений викладач: " + formattedSurName + " " + formattedName + " " + formattedPb + ", нова посада: " + formattedPosition + ", нова кафедра: " + formattedDep );
    }

    /**
     * Сортування студентів
     */
    private static void studSort(University university) {
        System.out.println("Оберіть, що саме Ви хочете робити зі студентами: 1 - знайти студента за ПІБ, 2 - знайти студента за групою, 3 - знайти студента за курсом, 4 - вивести всіх студентів, упорядкованих за курсами, 5 - вивести студентів, упорядкованих по алфавіту, 6 - вивести студентів кафедри за курсами, 7 - вивести студентів кафедри за алфавітом, 8 - вивести всіх студентів конкретного курсу, 9 - вивести студентів кафедри конкретного курсу, 10 - редагувати студента, 11 - додати студента, 12 - видалити студента: ");
        int chooseStudSorting= DataInput.getInt(null);
        switch (chooseStudSorting) {
            case 1 -> {
                System.out.println("Введіть ПІБ студента, якого шукаєте: ");
                String students = null;
                try {
                    students = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String yourStudent = university.searchStudentsByName(students);
                System.out.println("Шуканий студент: ");

                System.out.println(yourStudent);

            }
            case 2 -> {
                System.out.println("Введіть номер групи, щоб знайти відповідних студентів: ");
                int groupNum = DataInput.getInt(null);
                university.searchStudentsByYear(groupNum);
                System.out.println("Ваші студенти обраної групи: ");
                System.out.println(university.searchStudentsByGroup(groupNum));
            }
           case 3 -> {
               System.out.println("Введіть номер курсу, щоб знайти відповідних студентів: ");
               int courseNum = DataInput.getInt(null);
               university.searchStudentsByYear(courseNum);
               System.out.println("Ваші студенти обраного курсу: ");
               System.out.println(university.searchStudentsByYear(courseNum));
           }
            case 4 -> {
                System.out.println("Усі студенти, упорядковані за курсами: ");
                String students = university.getSortedStudentsByYear();
                System.out.println(students);
            }
            case 5 -> {
                System.out.println("Усі студенти, посортовані по алфавіту: ");
                String students = university.getSortedFacultyStudentsByAlphabet(0);
                System.out.println(students);
            }
            case 6 -> {
                System.out.println("Студенти кафедри, впорядковані за курсами: ");
                String students = university.getSortedDepartmentStudentsByYear(0);
                System.out.println(students);
            }
            case 7 -> {
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
                    System.out.println("Студенти кафедри, що навчаються на конкретному курсі: ");
                    String students = university.getDepartmentStudentsOfYear(0, courseNum);
                    System.out.println(students);
                }
            }
            case 10 -> {
                editStudent();
            }
            case 11 -> {
                createStud();
            }
            case 12 -> {
                System.out.println("Введіть ПІБ студента, якого хочете видалити: ");
                try {
                    String student = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Студента видалено!");

            }
        }
    }

    /**
     * Редагування студента
     */
    private static void editStudent() {
        String name;
        String surname;
        String pb;
        int newGroup;
        int newCourse;
        String department;
        System.out.println("Введіть нове ім'я студента: ");
        try {
            name = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String formattedName = Utils.formatPersonName(name);
        System.out.println("Введіть нове прізвище студента: ");
        try {
            surname = DataInput.getString();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        String formattedSurName = Utils.formatPersonName(surname);
        System.out.println("Введіть нове по батькові студента: ");
        try {
            pb = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String formattedPb = Utils.formatPersonName(pb);
        System.out.println("Введіть нову групу студента: ");
        newGroup = DataInput.getInt(null);
        int formattedGroup = newGroup;
        System.out.println("Введіть новий курс студента: ");
        newCourse = DataInput.getInt(null);
        int formattedCourse = newCourse;
        System.out.println("Введіть нову кафедру студента: ");
        try {
            department = DataInput.getString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String formattedDep = department;

        System.out.println("Змінений студент: " + formattedSurName + " " + formattedName + " " + formattedPb + ", нова група: " + formattedGroup + ", новий курс:  " + formattedCourse + ", нова кафедра: " + formattedDep );
    }

    /**
     * Створення факультета
     */
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
            break;
        }
    }

    /**
     * Створення кафедри
     */
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

    /**
     * Створення викладачів
     */
    private static void createTeacher() {
        System.out.println("Ви можете створити власних викладачів! ");
        System.out.println("Введіть кількість викладачів, яких хочете додати: ");
       int teacherNum = DataInput.getInt(null);
       if (teacherNum <= 0) {
           System.out.println("Введіть коректне значення!");
       }
       else {
           String name = null;
           String position = null;
           String department = null;
           String surname = null;
           String pb =  null;
           for (int i = 0; i < teacherNum; ++i) {
               System.out.println("Введіть ім'я викладача: ");
               try {
                   name = DataInput.getString();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Введіть прізвище викладача: ");
               try {
                   surname = DataInput.getString();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Введіть по батькові викладача: ");
               try {
                   pb = DataInput.getString();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Введіть кафедру викладача: ");
               try {
                   department = DataInput.getString();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }

               System.out.println("Введіть посаду викладача: ");
               try {
                   position = DataInput.getString();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Ваш викладач: " + name + " " + surname + " " + pb  + ", посада: " + position + ", кафедра:  " + department);

           }

       }
    }

    /**
     * Створення студентів
     */
    private static void createStud() {
        System.out.println("Ви можете створити власних студентів!");
        System.out.println("Введіть кількість студентів, яких хочете додати: ");
        int studentNum = DataInput.getInt(null);
        if (studentNum <= 0) {
            System.out.println("Введіть коректне значення!");
        } else {
            String name = null;
            String surname = null;
            String pb = null;
            int course = 0;
            String department = null;

            for (int i = 0; i < studentNum; ++i) {
                System.out.println("Введіть ім'я студента: ");
                try {
                    name = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Введіть прізвище студента: ");
                try {
                    surname = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Введіть по батькові студента: ");
                try {
                    pb = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Введіть номер групи студента: ");
                Integer group = DataInput.getInt(null);
                System.out.println("Введіть курс студента: ");
                course = DataInput.getInt(null);
                System.out.println("Введіть кафедру студента: ");
                try {
                    department = DataInput.getString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Ваш студент: " + name + " " + surname + " " + pb + ", група: " + group + ", курс: " + course + ", кафедра: " + department);
            }
        }
    }
}
