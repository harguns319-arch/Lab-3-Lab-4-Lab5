import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fileName = "students.txt";

        // Load students at startup
        ArrayList<Student> list = FileUtil.readStudents(fileName);

        System.out.println("Loaded students from file:");
        for (Student s : list) {
            System.out.println(s);
        }

        // RandomAccessFile demo
        FileUtil.randomAccessDemo(fileName);

        StudentManager sm = new StudentManager(list);
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

            switch (ch) {
                case 1: sm.addStudent(); break;
                case 2: sm.viewStudents(); break;
                case 3: sm.searchStudent(); break;
                case 4: sm.deleteStudent(); break;
                case 5: sm.sortByMarks(); break;
                case 6:
                    FileUtil.writeStudents(fileName, list);
                    System.out.println("Data Saved. Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
