package service;

import java.util.*;
import model.*;
import util.Loader;

public class StudentManager implements RecordActions {

    private List<Student> students = new ArrayList<>();
    private Map<Integer, Student> studentMap = new HashMap<>();

    public StudentManager(List<Student> list) {
        this.students = list;
        for (Student s : list) {
            studentMap.put(s.getRollNo(), s);
        }
    }

    private void simulateLoading() {
        Thread t = new Thread(new Loader());
        t.start();
        try { t.join(); } catch (Exception ignored) {}
    }

    @Override
    public void addStudent() {
        simulateLoading();
        Student s = new Student();
        s.inputDetails();

        if (studentMap.containsKey(s.getRollNo())) {
            System.out.println("Duplicate Roll No! Cannot add student.");
            return;
        }

        students.add(s);
        studentMap.put(s.getRollNo(), s);
        System.out.println("Student Added!");
    }

    @Override
    public void deleteStudent() throws StudentNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();

        Iterator<Student> it = students.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Student s = it.next();
            if (s.getName().equalsIgnoreCase(name)) {
                it.remove();
                studentMap.remove(s.getRollNo());
                found = true;
                break;
            }
        }

        if (!found) throw new StudentNotFoundException("Student not found!");

        System.out.println("Student deleted.");
    }

    @Override
    public void updateStudent() throws StudentNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter roll number to update: ");
        int roll = Integer.parseInt(sc.nextLine());

        if (!studentMap.containsKey(roll))
            throw new StudentNotFoundException("Roll No does not exist!");

        Student s = studentMap.get(roll);

        System.out.print("Enter new marks: ");
        double marks = Double.parseDouble(sc.nextLine());
        s.calculateGrade();

        System.out.println("Record Updated!");
    }

    @Override
    public void searchStudent() throws StudentNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.displayDetails();
                return;
            }
        }
        throw new StudentNotFoundException("Student not found!");
    }

    @Override
    public void viewAllStudents() {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            it.next().displayDetails();
        }
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Sorted by Marks:");
        viewAllStudents();
    }

    public List<Student> getList() {
        return students;
    }
}
