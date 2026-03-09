package Model;

import lombok.Data;

@Data
public class Review {
    private String reviewId;
    private String exchangeId;
    private String reviewerId;
    private String revieweeId;
    private int rating;
    private String comment;
    private String reviewDate;
    private String reviewTime;
}
