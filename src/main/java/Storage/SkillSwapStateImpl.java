package Storage;

import Model.Exchange;
import Model.Offer;
import Model.Request;
import Model.Review;
import Model.Skill;
import Model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillSwapStateImpl implements SkillSwapState {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Skill> skills = new HashMap<>();
    private Map<String, Review> reviews = new HashMap<>();
    private Map<String, Request> requests = new HashMap<>();
    private Map<String, Offer> offers = new HashMap<>();
    private Map<String, Exchange> exchanges = new HashMap<>();
}
