package Model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offer {
    private String studentId;
    private String skillId;
    private String proficiencyLevel;
    private List<String> notes;
}
