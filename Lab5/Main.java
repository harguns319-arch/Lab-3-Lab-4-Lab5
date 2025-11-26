import service.StudentManager;
import util.FileUtil;
import model.StudentNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String file = "students.txt";

        List students = FileUtil.loadStudents(file);
        StudentManager sm = new StudentManager(students);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");

            System.out.print("Enter choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            try {
                switch (ch) {
                    case 1: sm.addStudent(); break;
                    case 2: sm.viewAllStudents(); break;
                    case 3: sm.searchStudent(); break;
                    case 4: sm.deleteStudent(); break;
                    case 5: sm.sortByMarks(); break;
                    case 6:
                        FileUtil.saveStudents(file, sm.getList());
                        System.out.println("Saved and exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (StudentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
