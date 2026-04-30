package Service.Offer;

import Model.Offer;
import Model.Skill;
import Model.Student;

import java.util.List;

public interface OfferService {
    Offer createOffer(String offerId,
    Student student,
    Skill skill,
    String proficiencyLevel,
    List<String> notes,
    boolean active);
    List<Offer> getAllActiveOffers();
    List<Offer> getOfferByStudentId(String studentId);
}
