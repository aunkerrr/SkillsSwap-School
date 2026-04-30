package Service;

import Model.Student;
import Storage.SkillSwapState;
import Util.IdGeneratorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentServiceImpl implements StudentService{
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final SkillSwapState state;

    public StudentServiceImpl(SkillSwapState state) {
        this.state = state;
    }

    @Override
    public void registerStudent(String studentID, String name, String surname,
                                String email, String phoneNumber,
                                int classNumber, String sectionLetter) {
        String id = IdGeneratorImpl.generateUuid();

        Student newStudent = new Student(id, name,
                surname, email, phoneNumber,
                classNumber, sectionLetter);

        state.getStudents().put(id, newStudent);

    logger.info("Registered student: {} {} (ID:{})", name, surname, id);
    
    }

    @Override
    public void printAllStudent() {
        if (state.getStudents().isEmpty()) {
            System.out.println("There is no students registered in system...");
            return;
        }

        System.out.println("\n--- List of students SkillSwap ---\n");

        for (Student s : state.getStudents().values()) {
            String shortId = s.getStudentID().substring(0, 8);
            System.out.println("[" + shortId + "...]"
                    + s.getName() + " " + s.getSurname() + " | Class: " + s.getClassNumber()
                    + " " + s.getSectionLetter() + " | Contacts: " + s.getEmail() + " "
                    + s.getPhoneNumber()) ;
        }

        System.out.println("----------------------------------\n");
    }
}