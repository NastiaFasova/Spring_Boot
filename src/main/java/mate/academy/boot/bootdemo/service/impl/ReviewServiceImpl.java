package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.repository.ReviewRepository;
import mate.academy.boot.bootdemo.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final EntityManager manager;

    public ReviewServiceImpl(ReviewRepository reviewRepository, EntityManager manager) {
        this.reviewRepository = reviewRepository;
        this.manager = manager;
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
    public List<String> getMostActiveUsers(int limit) {
        return manager.createQuery("SELECT r.profileName from Review r "
                        + "GROUP BY r.profileName ORDER BY COUNT(r.profileName) desc",
                String.class)
                .setMaxResults(limit).getResultList();
    }
}
