package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.User;

public interface ReviewService {
    Review save(Review review);

    List<Review> findAll();

    Optional<Review> findById(Long id);

    List<User> getMostActiveUsers(int limit);
}
