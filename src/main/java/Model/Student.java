package Model;

import lombok.Data;

@Data
public class Student {
    private final String studentID;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private int classNumber;
    private String sectionLetter;
}
