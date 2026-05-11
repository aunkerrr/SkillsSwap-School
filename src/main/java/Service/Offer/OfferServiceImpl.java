package Service.Offer;

import Model.Offer;
import Model.Skill;
import Model.Student;
import Storage.SkillSwapState;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class OfferServiceImpl implements OfferService{
    private static final Logger logger = Logger.getLogger(OfferServiceImpl.class.getName());

    private final SkillSwapState state;

    public OfferServiceImpl(SkillSwapState state) {
        this.state = state;
    }

    @Override
    public Offer createOffer(String offerId, Student student,
                             Skill skill, String proficiencyLevel,
                             List<String> notes, boolean active) {
        if (student == null || skill == null) {
            logger.warning("Attempt of creating Offer with empty student or skill.");
            throw new RuntimeException("There is nothing in student or skill");
        }

        Offer newOffer = new Offer(offerId, student, skill, proficiencyLevel, notes, active);

        state.getOffers().put(offerId, newOffer);

        logger.info("Successfully created Offer [ ID: " + offerId + " ] from the student [ ID: " + student.getStudentID() + " ] for skill: " + skill.getName());

        return newOffer;
    }

    @Override
    public List<Offer> getAllActiveOffers() {
        logger.info("Asked list of active Offers.");

        List<Offer> allActiveOffers = state.getOffers()
                .values()
                .stream()
                .filter(Offer::isActive)
                .collect(Collectors.toList());

        logger.info("Returned " + allActiveOffers.size() + " active offers ");
        return allActiveOffers;
    }

    @Override
    public List<Offer> getOfferByStudentId(String studentId) {
        logger.info("Research of Offers based on student's email: " + studentId);

        List<Offer> studentOffers = state.getOffers()
                .values()
                .stream()
                .filter(offer -> offer.getStudent().getStudentID().equals(studentId))
                .collect(Collectors.toList());

        if(studentOffers.isEmpty()) {
            logger.warning("Student with ID {" + studentId + "} still don't have created offers.");
        } else {
            logger.info("Found " + studentOffers + " for the student.");
        }

        return studentOffers;
    }
}
