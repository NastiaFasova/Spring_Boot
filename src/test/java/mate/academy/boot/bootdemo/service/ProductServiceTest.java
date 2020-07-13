package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductServiceTest {

    private ReviewService reviewService;
    private ProductService productService;
    private final Review firstReview = new Review();
    private final Review secondReview = new Review();

    private final Product firstProduct = new Product();
    private final Product secondProduct = new Product();

    @Before
    public void setUp() {
        reviewService = Mockito.mock(ReviewService.class);
        productService = Mockito.mock(ProductService.class);
        firstReview.setId(1L);
        secondReview.setId(2L);
        firstReview.setProfileName("firstProfileName");
        secondReview.setProfileName("secondProfileName");
        firstProduct.setId("1234");
        secondProduct.setId("10988");
        firstReview.setProduct(firstProduct);
        secondReview.setProduct(secondProduct);
        reviewService.save(firstReview);
        reviewService.save(secondReview);
    }

    @Test
    public void saveProductTest() {
        Mockito.when(reviewService.save(firstReview)).thenReturn(firstReview);
        Mockito.when(reviewService.save(secondReview)).thenReturn(secondReview);
        Assert.assertEquals(firstReview.getProduct(), firstProduct);
        Assert.assertEquals(secondReview.getProduct(), secondProduct);
    }

    @Test
    public void findProductById()   {
        Mockito.when(productService.findById("1234")).thenReturn(Optional.of(firstProduct));
        Mockito.when(productService.findById("10988")).thenReturn(Optional.of(secondProduct));
    }

    @Test
    public void findAllProductsTest() {
        Mockito.when(productService.findAll()).thenReturn(List.of(secondProduct, firstProduct));
   }

    @Test
    public void findMostCommentedProductsTest() {
        Mockito.when(productService.getMostCommentedProducts(1, 1, "id"))
                .thenReturn(List.of(firstProduct));
        Mockito.when(productService.getMostCommentedProducts(1, 10, "id"))
                .thenReturn(List.of(firstProduct, secondProduct));
    }
}
