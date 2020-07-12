package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReviewServiceTest {
    private AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext("mate.academy.boot.bootdemo");
    private final ReviewService reviewService = context.getBean(ReviewService.class);
    private final UserService userService = context.getBean(UserService.class);
    private final Review firstReview = new Review();
    private final Review secondReview = new Review();

    @Before
    public void setUp() {
        firstReview.setId(1L);
        secondReview.setId(2L);
        firstReview.setProfileName("firstProfileName");
        secondReview.setProfileName("secondProfileName");
        reviewService.save(firstReview);
        reviewService.save(secondReview);
    }

    @Test
    public void saveReviewTest() {
        Assert.assertEquals(firstReview, reviewService.save(firstReview));
        Assert.assertEquals(secondReview, reviewService.save(secondReview));
    }

    @Test
    public void findReviewById()   {
        Assert.assertEquals(Optional.of(firstReview), reviewService.findById(1L));
        Assert.assertEquals(Optional.of(secondReview), reviewService.findById(2L));
    }

    @Test
    public void findAllReviewsTest() {
        Assert.assertEquals(List.of(firstReview, secondReview), reviewService.findAll());
    }

    @Test
    public void findMostActiveUsersTest() {
        Assert.assertEquals(List.of(new User(firstReview.getProfileName())),
                userService.findActiveUsers(1, 1));
        Assert.assertEquals(List.of(new User(secondReview.getProfileName()),
                new User(firstReview.getProfileName())),
                userService.findActiveUsers(10, 10));
    }

    @Test
    public void deleteTest() {
        reviewService.deleteById(firstReview.getId());
        Assert.assertEquals(List.of(secondReview), reviewService.findAll());
    }
}
