package Service.Student;

public interface StudentService {
    void registerStudent(String name,
                         String surname,
                         String email,
                         String phoneNumber,
                         int classNumber,
                         String sectionLetter);
    void printAllStudent();
}
