public class Main {
    public static void main(String[] args) {

        StudentManager sm = new StudentManager();

        try {
            sm.addStudent();
        } catch (StudentNotFoundException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }
}
