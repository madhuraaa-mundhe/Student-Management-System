import java.util.Scanner;

public class Main {

    // Method to safely read integer input
    public static int getValidInt(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // Remove invalid input
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
System.out.println("2. View Students");
System.out.println("3. Search Student by ID");
System.out.println("4. Search Student by Name");
System.out.println("5. Update Student");
System.out.println("6. Delete Student");
System.out.println("7. Total Students");
System.out.println("8. Sort Students by Name");
System.out.println("9. Exit");

            choice = getValidInt(sc, "Enter your choice: ");
            sc.nextLine();

            switch (choice) {

                case 1:

                    int id = getValidInt(sc, "Enter Student ID: ");
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    int age = getValidInt(sc, "Enter Age: ");
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    manager.addStudent(new Student(id, name, age, course));
                    break;

                case 2:

                    manager.displayStudents();
                    break;

                case 3:

                    int searchId = getValidInt(sc, "Enter Student ID to Search: ");
                    sc.nextLine();

                    manager.searchStudent(searchId);
                    break;

                case 4:

                    System.out.print("Enter Student Name to Search: ");
                    String searchName = sc.nextLine();

                    manager.searchStudentByName(searchName);
                    break;

                case 5:

                    int updateId = getValidInt(sc, "Enter Student ID to Update: ");
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    int newAge = getValidInt(sc, "Enter New Age: ");
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    manager.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 6:

                    int deleteId = getValidInt(sc, "Enter Student ID to Delete: ");
                    sc.nextLine();

                    manager.deleteStudent(deleteId);
                    break;

                case 7:

                    manager.totalStudents();
                    break;

                case 8:

    manager.sortStudents();
    break;

case 9:

    System.out.println("Thank you for using the Student Management System!");
    break;

                default:

                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}