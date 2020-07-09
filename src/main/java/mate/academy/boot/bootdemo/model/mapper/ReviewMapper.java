package mate.academy.boot.bootdemo.model.mapper;

import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review getReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setProfileName(reviewDto.getProfileName());
        review.setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator());
        review.setScore(reviewDto.getScore());
        review.setTime(reviewDto.getTime());
        review.setText(reviewDto.getText());
        review.setProduct(new Product(reviewDto.getId()));
        review.setUser(new User(reviewDto.getUserId()));
        return review;
    }

    public ReviewDto getReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setProfileName(review.getProfileName());
        reviewDto.setHelpfulnessDenominator(review.getHelpfulnessDenominator());
        reviewDto.setHelpfulnessNumerator(review.getHelpfulnessNumerator());
        reviewDto.setScore(review.getScore());
        reviewDto.setTime(review.getTime());
        reviewDto.setText(review.getText());
        reviewDto.setProductId(review.getProduct().getId().toString());
        reviewDto.setUserId(review.getUser().getId().toString());
        return reviewDto;
    }
}
