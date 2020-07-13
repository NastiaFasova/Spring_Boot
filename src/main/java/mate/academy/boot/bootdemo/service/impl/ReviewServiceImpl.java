package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.repository.ReviewRepository;
import mate.academy.boot.bootdemo.service.ReviewService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static final Logger LOGGER = Logger.getLogger(ReviewServiceImpl.class);
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        LOGGER.info("The review was successfully saved into the db");
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        LOGGER.info("All the reviews were retrieved from the db");
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> findById(Long id) {
        LOGGER.info("The review with the id " + id + " was successfully retrieved from the db");
        return reviewRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        LOGGER.info("The review with the id " + id + " was successfully removed from the db");
        reviewRepository.deleteById(id);
        return true;
    }

    @Override
    public Review findByIdAndUserLogin(Long id, String login) {
        LOGGER.info("The review with the id " + id + " and login "
                + login + " was found");
        return reviewRepository.findByIdAndUserLogin(id, login);
    }
}
