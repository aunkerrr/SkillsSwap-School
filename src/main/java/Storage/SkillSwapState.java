package Storage;

import Model.Exchange;
import Model.Offer;
import Model.Review;
import Model.Skill;
import Model.Student;
import Model.Request;

import java.util.Map;

public interface SkillSwapState {
    Map<String, Student> getStudents();
    Map<String, Skill> getSkills();
    Map<String, Review> getReviews();
    Map<String, Request> getRequests();
    Map<String, Offer> getOffers();
    Map<String, Exchange> getExchanges();
}
