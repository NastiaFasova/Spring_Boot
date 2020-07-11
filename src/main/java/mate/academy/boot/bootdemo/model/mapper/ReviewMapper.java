package mate.academy.boot.bootdemo.model.mapper;

import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import mate.academy.boot.bootdemo.service.ProductService;
import mate.academy.boot.bootdemo.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewDto getReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setProfileName(review.getProfileName());
        reviewDto.setHelpfulnessDenominator(review.getHelpfulnessDenominator());
        reviewDto.setHelpfulnessNumerator(review.getHelpfulnessNumerator());
        reviewDto.setScore(review.getScore());
        reviewDto.setTime(review.getTime());
        reviewDto.setText(review.getText());
        reviewDto.setProductId(review.getProduct().getId());
        reviewDto.setUserId(review.getUser().getId());
        return reviewDto;
    }

    public Review getReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setProfileName(reviewDto.getProfileName());
        review.setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator());
        review.setScore(reviewDto.getScore());
        review.setTime(reviewDto.getTime());
        review.setText(reviewDto.getText());
        review.setProduct(new Product(reviewDto.getProductId()));
        review.setUser(new User(reviewDto.getUserId()));
        return review;
    }
}
