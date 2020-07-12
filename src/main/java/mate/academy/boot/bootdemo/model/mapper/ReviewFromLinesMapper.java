package mate.academy.boot.bootdemo.model.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewFromLinesMapper {

    public ReviewLineDto getReviewLinesDtoFromLines(String[] reviewData) {
        ReviewLineDto reviewLineDto = new ReviewLineDto();
        reviewLineDto.setProductId(reviewData[1]);
        reviewLineDto.setUserId(reviewData[2]);
        reviewLineDto.setProfileName(reviewData[3]);
        reviewLineDto.setHelpfulnessNumerator(Long.parseLong(reviewData[4]));
        reviewLineDto.setHelpfulnessDenominator(Long.parseLong(reviewData[5]));
        reviewLineDto.setScore(Long.parseLong(reviewData[6]));
        LocalDateTime time =
                Instant.ofEpochMilli(Long.parseLong(reviewData[7]))
                        .atZone(ZoneId.systemDefault()).toLocalDateTime();
        reviewLineDto.setTime(time);
        reviewLineDto.setSummary(reviewData[8]);
        reviewLineDto.setText(reviewData[9]);
        return reviewLineDto;
    }
}
