package Storage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InMemoryStorageImpl implements InMemoryStorage {
    private static final Logger logger = LoggerFactory.getLogger(InMemoryStorageImpl.class);

    @Override
    public SkillSwapStateImpl load() {
        logger.info("Initialization of empty storage in RAM.");
        return new SkillSwapStateImpl();
    }

    @Override
    public void save(SkillSwapStateImpl state) {
        logger.info("Data saved in RAM");
    }
}
