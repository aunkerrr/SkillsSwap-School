package Service;

import Model.Student;
import Storage.SkillSwapState;
import Storage.SkillSwapStateImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentServiceImpl implements StudentService{
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final SkillSwapState state;

    public StudentServiceImpl(SkillSwapState state) {
        this.state = state;
    }


    @Override
    public void registerStudent(String studentID, String name, String surname, String email, String phoneNumber, int classNumber, String sectionLetter) {

    }

    @Override
    public void printAllStudent() {

    }
}