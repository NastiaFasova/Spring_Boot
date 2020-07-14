package mate.academy.boot.bootdemo.repository;

import java.util.List;
import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.model.Review;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ReviewRepository reviewRepository;

    private Review review = new Review();

    @Test
    public void saveAndFindReviewTest() {
        review = entityManager.persistAndFlush(review);
        Assert.assertEquals(reviewRepository.findById(review.getId()).orElseThrow(), review);
    }

    @Test
    public void getAllReviewsTest() {
        Review firstReview = new Review();
        Review secondReview = new Review();
        firstReview.setProfileName("firstReview");
        secondReview.setProfileName("secondReview");
        firstReview = entityManager.persistAndFlush(firstReview);
        secondReview = entityManager.persistAndFlush(secondReview);
        Assert.assertEquals(reviewRepository.findAll(), List.of(firstReview, secondReview));
    }

    @Test
    public void findByIdAndLoginTest() {
        InternetUser internetUser = new InternetUser();
        internetUser.setLogin("login");
        internetUser = entityManager.persistAndFlush(internetUser);
        review.setInternetUser(internetUser);
        review = entityManager.persistAndFlush(review);
        Assert.assertEquals(reviewRepository.findByIdAndUserLogin(review.getId(), "login"), review);
    }

    @Test
    public void deleteReviewTest() {
        entityManager.remove(review);
        Assert.assertEquals(reviewRepository.findAll(), List.of());
    }
}
