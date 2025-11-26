import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    // Read students from file
    public static ArrayList<Student> readStudents(String fileName) {
        ArrayList<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                list.add(new Student(roll, name, email, course, marks));
            }

        } catch (Exception e) {
            System.out.println("File read error: " + e.getMessage());
        }

        return list;
    }

    // Write students to file
    public static void writeStudents(String fileName, ArrayList<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }

    // Example of RandomAccessFile usage
    public static void randomAccessDemo(String fileName) {
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            System.out.println("RandomAccessFile read first 20 characters:");

            byte[] buffer = new byte[20];
            raf.read(buffer);
            System.out.println(new String(buffer));

            raf.close();
        } catch (Exception e) {
            System.out.println("RandomAccessFile error: " + e.getMessage());
        }
    }
}
