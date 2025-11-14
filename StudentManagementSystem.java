import java.util.ArrayList;
import java.util.Scanner;
class Student {
    int id;
    String name;
    int marks;
    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}
public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Student Record Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: 
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    // ADD
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        students.add(new Student(id, name, marks));
        System.out.println("Student Added Successfully!");
    }
    // VIEW
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }
    // UPDATE
    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Marks: ");
                s.marks = sc.nextInt();

                System.out.println("Record Updated Successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
    // DELETE
    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Record Deleted Successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}