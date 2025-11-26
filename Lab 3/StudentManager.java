public class StudentManager implements RecordActions {

    @Override
    public void addStudent() throws StudentNotFoundException {

        try {
            // Your fixed details
            Integer roll = 121;   // You can change if needed
            String name = "Hargun Singh";
            String email = "harguns319@gmail.com";
            String course = "B.Tech CSE";
            Double marks = 85.0;  // You can change marks

            // Simulated loading
            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            // Display student details
            System.out.println("Roll No: " + roll);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Course: " + course);
            System.out.println("Marks: " + marks);

            // Grade calculation
            String grade;
            if (marks >= 90) grade = "A";
            else if (marks >= 75) grade = "B";
            else if (marks >= 60) grade = "C";
            else if (marks >= 40) grade = "D";
            else grade = "F";

            System.out.println("Grade: " + grade);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new StudentNotFoundException("Student record could not be created!");
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}
