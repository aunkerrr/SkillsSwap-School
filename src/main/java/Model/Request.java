package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    private String requestId;
    private String studentId;
    private String skillId;
    private String urgencyLevel;
    private String notes;
}
