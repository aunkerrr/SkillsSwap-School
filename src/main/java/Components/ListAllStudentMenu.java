package Components;

import Model.Student;
import Service.Student.StudentService;

import java.util.Collection;

public class ListAllStudentMenu {
    public void printStudentsMenu(StudentService studentService) {
        Collection<Student> students = studentService.getAllStudent();

        if (students.isEmpty()) {
            System.out.println("There is no students registered in system...");
            return;
        }

        System.out.println("\n--- List of students SkillSwap ---\n");

        for (Student s : students) {
            String shortId = s.getStudentID().substring(0, 8);
            System.out.println("[" + shortId + "...]"
                    + s.getName() + " " + s.getSurname() + " | Class: " + s.getClassNumber()
                    + " " + s.getSectionLetter() + " | Contacts: " + s.getEmail() + " "
                    + s.getPhoneNumber()) ;
        }

        System.out.println("----------------------------------\n");
    }
}
