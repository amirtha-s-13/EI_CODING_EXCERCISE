import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class VirtualClassroomManager {
    private static final Logger logger = Logger.getLogger(VirtualClassroomManager.class.getName());
    private Map<String, Classroom> classrooms;

    public VirtualClassroomManager() {
        classrooms = new HashMap<>();
    }

    public void addClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            classrooms.put(name, new Classroom(name));
            logger.info("Classroom " + name + " has been created.");
            System.out.println("Classroom " + name + " has been created.");
        } else {
            logger.warning("Classroom " + name + " already exists.");
            System.out.println("Classroom " + name + " already exists.");
        }
    }

    public void removeClassroom(String name) {
        if (classrooms.containsKey(name)) {
            classrooms.remove(name);
            logger.info("Classroom " + name + " has been removed.");
            System.out.println("Classroom " + name + " has been removed.");
        } else {
            logger.warning("Classroom " + name + " does not exist.");
            System.out.println("Classroom " + name + " does not exist.");
        }
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("Available classrooms:");
            for (String className : classrooms.keySet()) {
                System.out.println(className);
            }
        }
    }

    public void addStudent(String studentId, String studentName, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Student student = new Student(studentId, studentName);
            classroom.addStudent(student);
        } else {
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.listStudents();
        } else {
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails, LocalDate dueDate) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Assignment assignment = new Assignment(assignmentDetails, dueDate);
            classroom.scheduleAssignment(assignment);
        } else {
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listAssignments(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.listAssignments();
        } else {
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, int assignmentIndex) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            if (assignmentIndex >= 0 && assignmentIndex < classroom.getAssignments().size()) {
                classroom.getAssignments().get(assignmentIndex).submitAssignment(studentId);
            } else {
                logger.warning("Assignment index " + assignmentIndex + " is out of range.");
                System.out.println("Assignment index " + assignmentIndex + " is out of range.");
            }
        } else {
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
