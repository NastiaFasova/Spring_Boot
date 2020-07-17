package mate.academy.boot.bootdemo.repository;

import java.util.List;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.Review;
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
public class ProductRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;
    private Review review;
    private Product product;

    @Before
    public void setUp() {
        review = new Review();
        product = new Product();
        product.setId("product");
        review.setProduct(product);
    }

    @Test
    public void saveAndFindProductTest() {
        product = entityManager.persistAndFlush(product);
        review = entityManager.persistAndFlush(review);
        Assert.assertEquals(productRepository.findById(product.getId()).orElseThrow(), product);
    }

    @Test
    public void getAllProductsTest() {
        Product firstProduct = new Product();
        Product secondProduct = new Product();
        Review firstReview = new Review();
        Review secondReview = new Review();
        firstProduct.setId("firstProduct");
        secondProduct.setId("secondProduct");
        firstReview.setProduct(firstProduct);
        secondReview.setProduct(secondProduct);
        firstProduct = entityManager.persistAndFlush(firstProduct);
        secondProduct = entityManager.persistAndFlush(secondProduct);
        firstReview = entityManager.persistAndFlush(firstReview);
        secondReview = entityManager.persistAndFlush(secondReview);
        Assert.assertEquals(productRepository.findAll(), List.of(firstProduct, secondProduct));
    }
}
