import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        // Setting up the logger to print to console
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

        boolean running = true;
 printMenu();
        while (running) {
           
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim();

            try {
                if (command.equalsIgnoreCase("exit")) {
                    running = false;
                } else if (command.startsWith("add_classroom")) {
                    String className = command.split(" ", 2)[1];
                    manager.addClassroom(className);
                } else if (command.startsWith("remove_classroom")) {
                    String className = command.split(" ", 2)[1];
                    manager.removeClassroom(className);
                } else if (command.startsWith("list_classrooms")) {
                    manager.listClassrooms();
                } else if (command.startsWith("add_student")) {
                    String[] parts = command.split(" ", 4);
                    String studentId = parts[1];
                    String studentName = parts[2];
                    String className = parts[3];
                    manager.addStudent(studentId, studentName, className);
                } else if (command.startsWith("list_students")) {
                    String className = command.split(" ", 2)[1];
                    manager.listStudents(className);
                } else if (command.startsWith("schedule_assignment")) {
                    String[] parts = command.split(" ", 4);
                    String className = parts[1];
                    String assignmentDetails = parts[2];
                    try {
                        LocalDate dueDate = LocalDate.parse(parts[3]);
                        manager.scheduleAssignment(className, assignmentDetails, dueDate);
                    } catch (DateTimeParseException e) {
                        logger.warning("Invalid date format. Please use YYYY-MM-DD.");
                        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                    }
                } else if (command.startsWith("list_assignments")) {
                    String className = command.split(" ", 2)[1];
                    manager.listAssignments(className);
                } else if (command.startsWith("submit_assignment")) {
                    String[] parts = command.split(" ", 4);
                    String studentId = parts[1];
                    String className = parts[2];
                    int assignmentIndex = Integer.parseInt(parts[3]);
                    manager.submitAssignment(studentId, className, assignmentIndex);
                } else {
                    logger.warning("Unknown command.");
                    System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                logger.severe("Error: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("Application terminated.");
    }

    private static void printMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("1. Add Classroom: add_classroom <class_name>");
        System.out.println("2. Remove Classroom: remove_classroom <class_name>");
        System.out.println("3. List Classrooms: list_classrooms");
        System.out.println("4. Add Student: add_student <student_id> <student_name> <class_name>");
        System.out.println("5. List Students: list_students <class_name>");
        System.out.println("6. Schedule Assignment: schedule_assignment <class_name> <assignment_details> <due_date>");
        System.out.println("7. List Assignments: list_assignments <class_name>");
        System.out.println("8. Submit Assignment: submit_assignment <student_id> <class_name> <assignment_index>");
        System.out.println("9. Exit: exit\n");
    }
}
