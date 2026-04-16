package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatchingResult {

    private String offerId;
    private String requestId;
    private int score;
    private String reason;
}