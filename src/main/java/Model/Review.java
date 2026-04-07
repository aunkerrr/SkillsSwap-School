package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    private String reviewId;
    private Exchange exchange;
    private Student reviewer;
    private Student reviewee;
    private int rating;
    private String comment;
    private String reviewDate;
    private String reviewTime;
}
