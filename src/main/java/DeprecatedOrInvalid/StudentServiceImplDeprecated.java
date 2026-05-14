package DeprecatedOrInvalid;

import Model.Student;
import Storage.SkillSwapState;

@Deprecated
public class StudentServiceImplDeprecated {
    private final SkillSwapState state;

    public StudentServiceImplDeprecated(SkillSwapState state) {
        this.state = state;
    }

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
