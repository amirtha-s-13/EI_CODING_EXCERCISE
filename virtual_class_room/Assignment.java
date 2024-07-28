import java.time.LocalDate;
import java.util.logging.Logger;

public class Assignment {
    private static final Logger logger = Logger.getLogger(Assignment.class.getName());
    private String details;
    private LocalDate dueDate;

    public Assignment(String details, LocalDate dueDate) {
        this.details = details;
        this.dueDate = dueDate;
    }

    public String getDetails() {
        return details;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void submitAssignment(String studentId) {
        logger.info("Assignment submitted by Student " + studentId + ": " + details);
        System.out.println("Assignment submitted by Student " + studentId + " in class.");
    }
}
