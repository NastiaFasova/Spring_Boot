package mate.academy.boot.bootdemo.repository;

import java.util.List;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    private Review review;
    private User user;

    @Before
    public void setUp() {
        review = new Review();
        user = new User();
        user.setId("product");
        review.setUser(user);
    }

    @Test
    public void saveAndFindUserTest() {
        user = entityManager.persistAndFlush(user);
        review = entityManager.persistAndFlush(review);
        Assert.assertEquals(userRepository.findById(user.getId()).orElseThrow(), user);
    }

    @Test
    public void getAllProductsTest() {
        User firstUser = new User();
        User secondUser = new User();
        Review firstReview = new Review();
        Review secondReview = new Review();
        firstUser.setId("firstUser");
        secondUser.setId("secondUser");
        firstReview.setUser(firstUser);
        secondReview.setUser(secondUser);
        firstUser = entityManager.persistAndFlush(firstUser);
        secondUser = entityManager.persistAndFlush(secondUser);
        firstReview = entityManager.persistAndFlush(firstReview);
        secondReview = entityManager.persistAndFlush(secondReview);
        Assert.assertEquals(userRepository.findAll(), List.of(firstUser, secondUser));
    }
}
