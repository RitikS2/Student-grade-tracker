import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Student Grade Tracker!");
        
        // Create arrays to store student names and their grades for various subjects
        String[] studentNames = new String[10]; 
        double[][] grades = new double[10][5]; 
        
        int numberOfStudents = 0; 
        
        // Main menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("Main Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Grades");
            System.out.println("3. Calculate Average");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Add a student
                    if (numberOfStudents < studentNames.length) {
                        System.out.print("Enter student name: ");
                        scanner.nextLine(); 
                        String name = scanner.nextLine();
                        studentNames[numberOfStudents] = name;
                        numberOfStudents++;
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Maximum number of students reached.");
                    }
                    break;
                case 2:
                    // Enter grades
                    if (numberOfStudents > 0) {
                        System.out.print("Enter student name: ");
                        scanner.nextLine(); 
                        String name = scanner.nextLine();
                        int studentIndex = -1;
                        for (int i = 0; i < numberOfStudents; i++) {
                            if (studentNames[i].equalsIgnoreCase(name)) {
                                studentIndex = i;
                                break;
                            }
                        }
                        if (studentIndex != -1) {
                            for (int i = 0; i < 5; i++) {
                                System.out.print("Enter grade for subject " + (i + 1) + ": ");
                                grades[studentIndex][i] = scanner.nextDouble();
                            }
                            System.out.println("Grades entered successfully!");
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else {
                        System.out.println("No students added yet.");
                    }
                    break;
                case 3:
                    // Calculate average
                    if (numberOfStudents > 0) {
                        System.out.print("Enter student name: ");
                        scanner.nextLine(); 
                        String name = scanner.nextLine();
                        int studentIndex = -1;
                        for (int i = 0; i < numberOfStudents; i++) {
                            if (studentNames[i].equalsIgnoreCase(name)) {
                                studentIndex = i;
                                break;
                            }
                        }
                        if (studentIndex != -1) {
                            double total = 0;
                            for (int i = 0; i < 5; i++) {
                                total += grades[studentIndex][i];
                            }
                            double average = total / 5;
                            System.out.println("Average for " + studentNames[studentIndex] + ": " + average);
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else {
                        System.out.println("No students added yet.");
                    }
                    break;
                case 4:
                    // Exit the program
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}
