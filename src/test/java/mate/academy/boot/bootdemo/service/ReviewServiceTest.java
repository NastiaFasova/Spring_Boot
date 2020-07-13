package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Review;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ReviewServiceTest {
    private ReviewService reviewService;
    private final Review firstReview = new Review();
    private final Review secondReview = new Review();

    @Before
    public void setUp() {
        reviewService = Mockito.mock(ReviewService.class);
        firstReview.setId(1L);
        secondReview.setId(2L);
        firstReview.setProfileName("firstProfileName");
        secondReview.setProfileName("secondProfileName");
        reviewService.save(firstReview);
        reviewService.save(secondReview);
    }

    @Test
    public void saveReviewTest() {
        Mockito.when(reviewService.save(firstReview)).thenReturn(firstReview);
        Mockito.when(reviewService.save(secondReview)).thenReturn(secondReview);
    }

    @Test
    public void findReviewById()   {
        Mockito.when(reviewService.findById(1L)).thenReturn(Optional.of(firstReview));
        Mockito.when(reviewService.findById(2L)).thenReturn(Optional.of(secondReview));
    }

    @Test
    public void findAllReviewsTest() {
        Mockito.when(reviewService.findAll()).thenReturn(List.of(firstReview, secondReview));
    }

    @Test
    public void deleteTest() {
        reviewService.deleteById(firstReview.getId());
        Mockito.when(reviewService.findAll()).thenReturn(List.of(secondReview));
    }
}
