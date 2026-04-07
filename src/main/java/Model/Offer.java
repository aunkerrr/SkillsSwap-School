package Model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offer {
    private String offerId;
    private Student student;
    private Skill skill;
    private String proficiencyLevel;
    private List<String> notes;
    private boolean active;
}
