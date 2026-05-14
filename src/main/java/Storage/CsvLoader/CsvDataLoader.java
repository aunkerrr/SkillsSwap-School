package Storage.CsvLoader;

import Storage.SkillSwapState;

public interface CsvDataLoader {
    void loadStudents(String filePath, SkillSwapState state);
}
