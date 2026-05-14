package Storage.CsvLoader;

import Model.Student;
import Storage.SkillSwapState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvDataLoaderImpl implements CsvDataLoader {
    private static final Logger logger = LoggerFactory.getLogger(CsvDataLoaderImpl.class);

    @Override
    public void loadStudents(String filePath, SkillSwapState state){
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

            String[] values = line.split(",");
                if (values.length == 7) {
                    String id = values[0].trim();
                    String name = values[1].trim();
                    String surname = values[2].trim();
                    String email = values[3].trim();
                    String phone = values[4].trim();
                    int classNum = Integer.parseInt(values[5].trim());
                    String section = values[6].trim();

                    Student student = new Student(id, name, surname, email, phone, classNum, section);

                    state.getStudents().put(id, student);
                }
            }

            logger.info("Successfully loaded: {} of student from CSV.", state.getStudents().size());

        } catch (IOException e) {
            logger.error("There is file reading ERROR: {}: {}", filePath, e.getMessage());
        } catch (NumberFormatException e) {
            logger.error("There is ERROR happened while parsing CSV numbers: {}", e.getMessage());
        }
    }
}
