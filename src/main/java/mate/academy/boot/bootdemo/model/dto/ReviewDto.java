package mate.academy.boot.bootdemo.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

import javax.persistence.Column;

@Data
public class ReviewDto {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    @Column(length = 1000)
    private String summary;
    @Column(length = 1000)
    private String text;
}
