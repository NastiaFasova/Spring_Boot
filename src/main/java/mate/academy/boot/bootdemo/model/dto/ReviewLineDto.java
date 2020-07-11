package mate.academy.boot.bootdemo.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewLineDto {
    private String productId;
    private String userId;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    private String summary;
    private String text;
}
