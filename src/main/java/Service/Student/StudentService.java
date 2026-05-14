package Service.Student;

import Model.Student;

import java.util.Collection;

public interface StudentService {
    void registerStudent(String name,
                         String surname,
                         String email,
                         String phoneNumber,
                         int classNumber,
                         String sectionLetter);
    Collection<Student> getAllStudent();
}
