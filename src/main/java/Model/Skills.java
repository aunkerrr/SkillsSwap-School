package Model;

import lombok.Data;

import java.util.List;

@Data
public class Skills {
    private String studentId;
    private String studentName;
    private List<String> skills;
}
