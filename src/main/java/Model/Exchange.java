package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exchange {
    private String exchangeId;
    private String requesterId;
    private String providerId;
    private String skillId;
    private String status;
}
