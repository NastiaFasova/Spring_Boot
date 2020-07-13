package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Review;

public interface ReviewService {
    Review save(Review review);

    List<Review> findAll();

    Optional<Review> findById(Long id);

    boolean deleteById(Long id);

    Review findByIdAndUserLogin(Long id, String login);
}
