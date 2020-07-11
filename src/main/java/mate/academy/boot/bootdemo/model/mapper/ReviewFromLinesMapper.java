package mate.academy.boot.bootdemo.model.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewFromLinesMapper {

    public ReviewDto getReviewDtoFromLines(String[] reviewData) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(Long.valueOf(reviewData[0]));
        reviewDto.setProductId(reviewData[1]);
        reviewDto.setUserId(reviewData[2]);
        reviewDto.setProfileName(reviewData[3]);
        reviewDto.setHelpfulnessNumerator(Long.valueOf(reviewData[4]));
        reviewDto.setHelpfulnessDenominator(Long.valueOf(reviewData[5]));
        reviewDto.setScore(Long.valueOf(reviewData[6]));
        LocalDateTime time =
                Instant.ofEpochMilli(Long.parseLong(reviewData[7]))
                        .atZone(ZoneId.systemDefault()).toLocalDateTime();
        reviewDto.setTime(time);
        reviewDto.setSummary(reviewData[8]);
        reviewDto.setText(reviewData[9]);
        return reviewDto;
    }
}
