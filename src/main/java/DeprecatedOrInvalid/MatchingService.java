package DeprecatedOrInvalid;

import Model.Offer;
import Model.Request;
import Storage.SkillSwapState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class MatchingService {

    private final SkillSwapState state;

    public MatchingService(SkillSwapState state) {
        this.state = state;
    }

    public List<MatchingResult> findOneWayMatches(String studentId) {

        List<MatchingResult> results = new ArrayList<>();

        Map<String, Request> requests = state.getRequests();
        Map<String, Offer> offers = state.getOffers();

        for (Request r : requests.values()) {

            if (!r.getStudent().getStudentID().equals(studentId)) continue;

            for (Offer o : offers.values()) {

                if (o.getStudent().getStudentID().equals(studentId)) continue;

                List<String> reasons = new ArrayList<>();
                int score = calculateScore(r, o, reasons);

                if (score > 0) {
                    results.add(new MatchingResult(
                            o.getOfferId(),
                            r.getRequestId(),
                            score,
                            String.join(", ", reasons)
                    ));
                }
            }
        }

        return results;
    }

    private int calculateScore(Request r, Offer o, List<String> reasons) {

        int score = 0;

        if (r.getSkill().getId().equals(o.getSkill().getId())) {
            score += 3;
            reasons.add("Skill match");
        }

        if (r.getUrgencyLevel().equals(o.getProficiencyLevel())) {
            score += 2;
            reasons.add("Level match");
        }

        if (r.getStudent().getClassNumber() == o.getStudent().getClassNumber()
                && r.getStudent().getSectionLetter().equals(o.getStudent().getSectionLetter())) {
            score += 1;
            reasons.add("Same class");
        }

        return score;
    }
}