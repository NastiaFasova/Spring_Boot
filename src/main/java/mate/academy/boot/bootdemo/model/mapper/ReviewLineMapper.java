package mate.academy.boot.bootdemo.model.mapper;

import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewLineMapper {

    public Review getReviewFromLine(ReviewLineDto reviewLineDto) {
        Review review = new Review();
        review.setProfileName(reviewLineDto.getProfileName());
        review.setHelpfulnessDenominator(reviewLineDto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(reviewLineDto.getHelpfulnessNumerator());
        review.setScore(reviewLineDto.getScore());
        review.setTime(reviewLineDto.getTime());
        review.setText(reviewLineDto.getText());
        review.setProduct(new Product(reviewLineDto.getProductId()));
        review.setUser(new User(reviewLineDto.getUserId()));
        return review;
    }

    public ReviewLineDto getReviewLineDto(Review review) {
        ReviewLineDto reviewLineDto = new ReviewLineDto();
        reviewLineDto.setProfileName(review.getProfileName());
        reviewLineDto.setHelpfulnessDenominator(review.getHelpfulnessDenominator());
        reviewLineDto.setHelpfulnessNumerator(review.getHelpfulnessNumerator());
        reviewLineDto.setScore(review.getScore());
        reviewLineDto.setTime(review.getTime());
        reviewLineDto.setText(review.getText());
        reviewLineDto.setProductId(review.getProduct().getId());
        reviewLineDto.setUserId(review.getUser().getId());
        return reviewLineDto;
    }
}
