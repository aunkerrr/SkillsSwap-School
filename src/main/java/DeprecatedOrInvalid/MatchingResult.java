package DeprecatedOrInvalid;

/* WHY:
* Because there was already model which
* satisfied all the requests */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Deprecated
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatchingResult {

    private String offerId;
    private String requestId;
    private int score;
    private String reason;
}