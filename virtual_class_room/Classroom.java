import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.logging.Logger;

public class Classroom {
    private static final Logger logger = Logger.getLogger(Classroom.class.getName());
    private String name;
    private Map<String, Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashMap<>();
        this.assignments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            logger.info("Student " + student.getId() + " has been enrolled in " + name + ".");
            System.out.println("Student " + student.getId() + " has been enrolled in " + name + ".");
        } else {
            logger.warning("Student " + student.getId() + " is already enrolled in " + name + ".");
            System.out.println("Student " + student.getId() + " is already enrolled in " + name + ".");
        }
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
        logger.info("Assignment for " + name + " has been scheduled.");
        System.out.println("Assignment for " + name + " has been scheduled.");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + name + ".");
        } else {
            System.out.println("Students enrolled in " + name + ":");
            for (Student student : students.values()) {
                System.out.println(student.getId() + ": " + student.getName());
            }
        }
    }

    public void listAssignments() {
        if (assignments.isEmpty()) {
            System.out.println("No assignments scheduled for " + name + ".");
        } else {
            System.out.println("Assignments for " + name + ":");
            for (int i = 0; i < assignments.size(); i++) {
                Assignment assignment = assignments.get(i);
                System.out.println((i + 1) + ": " + assignment.getDetails() + " (Due: " + assignment.getDueDate() + ")");
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
}
