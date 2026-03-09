package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@AllArgsConstructor
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
