package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductServiceTest {
    private AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext("mate.academy.boot.bootdemo");
    private final ProductService productService = context.getBean(ProductService.class);
    private final Product firstProduct = new Product();
    private final Product secondProduct = new Product();

    @Before
    public void setUp() {
        firstProduct.setId(1L);
        secondProduct.setId(2L);
        productService.save(firstProduct);
        productService.save(secondProduct);
    }

    @Test
    public void saveProductTest() {
        Assert.assertEquals(firstProduct, productService.save(firstProduct));
        Assert.assertEquals(secondProduct, productService.save(secondProduct));
    }

    @Test
    public void findProductById()   {
        Assert.assertEquals(Optional.of(firstProduct), productService.findById(1L));
        Assert.assertEquals(Optional.of(secondProduct), productService.findById(2L));
    }

    @Test
    public void findAllProductsTest() {
        productService.save(firstProduct);
        productService.save(secondProduct);
        Assert.assertEquals(List.of(firstProduct, secondProduct), productService.findAll());
    }

    @Test
    public void findMostCommentedProductsTest() {
        Assert.assertEquals(List.of(firstProduct), productService.getMostCommentedProducts(1));
        Assert.assertEquals(List.of(secondProduct, firstProduct), productService.getMostCommentedProducts(10));
    }
}
