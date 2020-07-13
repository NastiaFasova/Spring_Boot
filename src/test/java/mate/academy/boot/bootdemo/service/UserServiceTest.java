package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserServiceTest {
    private UserService userService;
    private ReviewService reviewService;
    private final User firstUser = new User();
    private final User secondUser = new User();
    private final Review firstReview = new Review();
    private final Review secondReview = new Review();

    @Before
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        reviewService = Mockito.mock(ReviewService.class);
        firstUser.setId("657784");
        secondUser.setId("65784");
        firstReview.setUser(firstUser);
        secondReview.setUser(secondUser);
        reviewService.save(firstReview);
        reviewService.save(secondReview);
    }

    @Test
    public void saveUserTest() {
        Mockito.when(reviewService.save(firstReview)).thenReturn(firstReview);
        Mockito.when(reviewService.save(secondReview)).thenReturn(secondReview);
        Assert.assertEquals(firstReview.getUser(), firstUser);
        Assert.assertEquals(secondReview.getUser(), secondUser);
    }

    @Test
    public void findUserById()   {
        Mockito.when(userService.findById("657784")).thenReturn(Optional.of(firstUser));
        Mockito.when(userService.findById("65784")).thenReturn(Optional.of(secondUser));
    }

    @Test
    public void findMostActiveUsersTest() {
        Mockito.when(userService.findActiveUsers(1,  1, "profileName"))
                .thenReturn(List.of(new User(firstReview.getProfileName())));

        Mockito.when(userService.findActiveUsers(1,  10, "profileName"))
                .thenReturn(List.of(new User(secondReview.getProfileName()),
                        new User(firstReview.getProfileName())));
    }

    @Test
    public void findAllUsersTest() {
        Mockito.when(userService.findAll()).thenReturn(List.of(firstUser, secondUser));
    }
}
