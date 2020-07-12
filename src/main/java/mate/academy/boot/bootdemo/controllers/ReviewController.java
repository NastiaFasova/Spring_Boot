package mate.academy.boot.bootdemo.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import mate.academy.boot.bootdemo.model.mapper.ReviewMapper;
import mate.academy.boot.bootdemo.service.InternetUserService;
import mate.academy.boot.bootdemo.service.ReviewService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;
    private final InternetUserService internetUserService;

    public ReviewController(ReviewMapper reviewMapper, ReviewService reviewService,
                            InternetUserService internetUserService) {
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
        this.internetUserService = internetUserService;
    }

    @PostMapping
    public void add(@RequestBody @Valid ReviewDto reviewDto, Authentication authentication) {
        InternetUser user = internetUserService.getByEmail(authentication.getName());
        Review review = reviewMapper.getReview(reviewDto);
        user.setReviews(Set.of(review));
        reviewService.save(review);
    }

    @GetMapping
    public List<ReviewDto> getAll() {
        List<Review> reviews = reviewService.findAll();
        return reviews.stream()
                .map(reviewMapper::getReviewDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/review")
    public ReviewDto getReviewById(@RequestParam Long id) {
        return reviewMapper.getReviewDto(reviewService.findById(id).orElseThrow());
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        reviewService.deleteById(id);
        return "Comment was successfully deleted";
    }

    @PutMapping
    public ReviewDto updateReview(@RequestBody @Valid ReviewDto reviewDto,
                                  Authentication authentication) {
        Review review
                = reviewService.findByIdAndUserLogin(reviewDto.getId(),authentication.getName());
        review.setText(reviewDto.getText());
        return reviewMapper.getReviewDto(reviewService.save(review));
    }
}
