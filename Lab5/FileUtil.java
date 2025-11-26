package util;

import java.io.*;
import java.util.*;
import model.Student;

public class FileUtil {

    public static List<Student> loadStudents(String fileName) {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                int roll = Integer.parseInt(d[0]);
                String name = d[1];
                String email = d[2];
                String course = d[3];
                double marks = Double.parseDouble(d[4]);

                list.add(new Student(roll, name, email, course, marks));
            }

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        return list;
    }

    public static void saveStudents(String fileName, List<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
