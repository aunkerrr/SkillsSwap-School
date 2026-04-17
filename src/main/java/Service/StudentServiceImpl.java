package Service;

import Model.Student;
import Storage.SkillSwapState;
import Storage.SkillSwapStateImpl;
import Util.IdGenerator;
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

    logger.info("Registrated student: {} {} (ID:{})", name, surname, id);
    
    }

    @Override
    public void printAllStudent() {

    }
}