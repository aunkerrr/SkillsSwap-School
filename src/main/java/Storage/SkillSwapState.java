package Storage;

import Model.*;
import java.util.Map;

public interface SkillSwapState {

    Map<String, Request> getRequests();
    Map<String, Offer> getOffers();
}