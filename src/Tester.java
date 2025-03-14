public class Tester {
    public static void main(String[] args) {
        welcomes();


    }

    private static void welcomes() {
        System.out.println("Вітаємо в нашому університеті! Дозвольте запропонувати Вам переглянути наші факультети, кафедри, студентів та викладачів.");
        while (true) {
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
                    continue;
            }
        }

    }

    private static void creatingNewObj() {
        System.out.println("Створімо новий об'єкт для нашого університету!");
        System.out.println("Будь ласка, оберіть, що саме Ви хочете створити");
        while (true) {
            System.out.println("Для створення факультету натисніть 1; для кафедри натисніть 2; для викладачів натисніть 3; для студентів натисніть 4:");
            int newObj = DataInput.getInt(null);
            switch (newObj) {
                case 1:
                    creatFuck();
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
            }
        }
    }



    private static void currentInfo() {
        System.out.println("Чудовий вибір! У нас є вже готові факультети, кафедри, виклаадчі та студенти!");
        System.out.println("Будь ласка, оберіть, з чим Ви хочете ознайомитись:");
        while (true) {
            System.out.println("Щоб працювати з факультетами, натисніть 1; для кафедр натисніть 2; для викладачів натисніть 3; для студентів натисніть 4:");
            int whichObj = DataInput.getInt(null);
            switch (whichObj) {
                case 1 -> facultySort();
                case 2 -> departmentSort();
                case 3 -> teachersSort();
                case 4 -> studSort();
                default -> System.out.println("Будь ласка, введіть коректне значення!");

            }
        }
    }

    private static void facultySort() {
    }
    private static void departmentSort() {
}
private static void teachersSort() {
}
private static void studSort() {}
    private static void creatFuck(){}
    private static void createDep(){
    }
    private static void createTeacher(){

    }
    private static void createStud(){

    }


}
