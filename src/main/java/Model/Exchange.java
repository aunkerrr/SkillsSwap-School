package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exchange {
    private String exchangeId;
    private Offer offer;
    private Request request;
    private String status;
    private String date;
}
