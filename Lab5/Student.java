package model;

import java.util.Scanner;

public class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student() {}

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public int getRollNo() { return rollNo; }
    public double getMarks() { return marks; }
    public String getName() { return name; }

    // Input details from user
    public void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        rollNo = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Email: ");
        email = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = Double.parseDouble(sc.nextLine());

        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90) grade = "A";
        else if (marks >= 75) grade = "B";
        else if (marks >= 60) grade = "C";
        else if (marks >= 40) grade = "D";
        else grade = "F";
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------");
    }

    @Override
    public void displayInfo() {
        displayDetails();
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + course + "," + marks;
    }
}
