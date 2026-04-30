package Service.Offer;

import Model.Offer;
import Model.Skill;
import Model.Student;

import java.util.List;
import java.util.logging.Logger;

public class OfferServiceImpl implements OfferService{
    private static final Logger logger = Logger.getLogger(OfferServiceImpl.class.getName());

    @Override
    public Offer createOffer(String offerId, Student student, Skill skill, String proficiencyLevel, List<String> notes, boolean active) {

    }

    @Override
    public List<Offer> getAllActiveOffers() {
        return List.of();
    }

    @Override
    public List<Offer> getOfferByStudentId(String studentId) {
        return List.of();
    }
}
