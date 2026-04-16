package Storage;

public interface InMemoryStorage {
    SkillSwapStateImpl load();

    void save(SkillSwapStateImpl state);
}
