package Service;

import Model.Skill;
import Storage.SkillSwapState;

public interface StudentService {
    void registerStudent(String studentID,
                         String name,
                         String surname,
                         String email,
                         String phoneNumber,
                         int classNumber,
                         String sectionLetter);
    void printAllStudent();
}
