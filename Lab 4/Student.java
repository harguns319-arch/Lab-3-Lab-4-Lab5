public class Student {
    private int roll;
    private String name;
    private String email;
    private String course;
    private double marks;

    public Student(int roll, String name, String email, String course, double marks) {
        this.roll = roll;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public int getRoll() { return roll; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return roll + "," + name + "," + email + "," + course + "," + marks;
    }
}
