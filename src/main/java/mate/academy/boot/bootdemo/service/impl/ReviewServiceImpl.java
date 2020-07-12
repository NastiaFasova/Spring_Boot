package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.repository.ReviewRepository;
import mate.academy.boot.bootdemo.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review findByIdAndUserLogin(Long id, String login) {
        return reviewRepository.findByIdAndUserLogin(id, login);
    }
}
