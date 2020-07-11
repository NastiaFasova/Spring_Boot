package mate.academy.boot.bootdemo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import mate.academy.boot.bootdemo.model.mapper.ReviewMapper;
import mate.academy.boot.bootdemo.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;

    public ReviewController(ReviewMapper reviewMapper, ReviewService reviewService) {
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
    }

    @PostMapping
    public void add(@RequestBody @Valid ReviewDto reviewDto) {
        reviewService.save(reviewMapper.getReview(reviewDto));
    }

    @GetMapping
    public List<ReviewDto> getAll() {
        List<Review> reviews = reviewService.findAll();
        return reviews.stream()
                .map(reviewMapper::getReviewDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReviewDto getReviewById(@PathVariable Long id) {
        return reviewMapper.getReviewDto(reviewService.findById(id).orElseThrow());
    }
}
