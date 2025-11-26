import java.util.*;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    // Add new student
    public void addStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        int roll = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = Double.parseDouble(sc.nextLine());

        students.add(new Student(roll, name, email, course, marks));
        System.out.println("Student Added Successfully!");
    }

    // View all students using Iterator
    public void viewStudents() {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(
                    "\nRoll No: " + s.getRoll() +
                            "\nName: " + s.getName() +
                            "\nEmail: " + s.getEmail() +
                            "\nCourse: " + s.getCourse() +
                            "\nMarks: " + s.getMarks()
            );
        }
    }

    // Search by name
    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name to Search: ");
        String name = sc.nextLine();

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println("\nStudent Found:");
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Delete student
    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name to Delete: ");
        String name = sc.nextLine();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.getName().equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Student Deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Sort by Marks using Comparator
    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students Sorted by Marks!");
        viewStudents();
    }
}
