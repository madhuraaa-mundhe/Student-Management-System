import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Constructor
    public StudentManager() {
        loadFromFile();
    }

    // Add Student
    public void addStudent(Student student) {

    // Check if ID already exists
    for (Student s : students) {

        if (s.getId() == student.getId()) {
            System.out.println("Student ID already exists!");
            return;
        }
    }

    students.add(student);
    saveToFile();

    System.out.println("Student added successfully!");
}

    // Display Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n----- Student List -----");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search Student
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                System.out.println("\nStudent Found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }
    // Search Student by Name
public void searchStudentByName(String name) {

    boolean found = false;

    for (Student student : students) {

        if (student.getName().equalsIgnoreCase(name)) {

            System.out.println(student);
            found = true;
        }
    }

    if (!found) {
        System.out.println("Student not found.");
    }
}

    // Update Student
    public void updateStudent(int id, String newName, int newAge, String newCourse) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(newName);
                student.setAge(newAge);
                student.setCourse(newCourse);

                saveToFile();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                saveToFile();

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }
    // Total Students
public void totalStudents() {

    System.out.println("Total Students: " + students.size());
}

    // Save to File
    public void saveToFile() {

        try {

            FileWriter writer = new FileWriter("students.txt");

            for (Student student : students) {

                writer.write(student.getId() + "," +
                             student.getName() + "," +
                             student.getAge() + "," +
                             student.getCourse() + "\n");
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving file.");
        }
    }
    // Sort Students by Name
public void sortStudents() {

    Collections.sort(students, new Comparator<Student>() {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareToIgnoreCase(s2.getName());
        }
    });

    System.out.println("Students sorted successfully!");
    displayStudents();
}

    // Load from File
    public void loadFromFile() {

        try {

            File file = new File("students.txt");

            if (!file.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                students.add(new Student(id, name, age, course));
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error loading file.");
        }
    }
}