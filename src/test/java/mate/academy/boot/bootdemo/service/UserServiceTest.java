package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;

import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {
    private AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext("mate.academy.boot.bootdemo");
    private final UserService userService = context.getBean(UserService.class);
    private final ProductService productService = context.getBean(ProductService.class);
    private final User firstUser = new User();
    private final User secondUser = new User();
    private final Product product = new Product();

    @Before
    public void setUp() {
        firstUser.setId(1L);
        secondUser.setId(2L);
        product.setId(1L);
        firstUser.setProduct(product);
        secondUser.setProduct(product);
        userService.save(firstUser);
        userService.save(secondUser);
    }

    @Test
    public void saveUserTest() {
        Assert.assertEquals(firstUser, userService.save(firstUser));
        Assert.assertEquals(secondUser, userService.save(secondUser));
    }

    @Test
    public void saveUserAndProductTest() {
        Assert.assertEquals(Optional.of(product), productService.findById(1L));
    }

    @Test
    public void findUserById()   {
        Assert.assertEquals(Optional.of(firstUser), userService.findById(1L));
        Assert.assertEquals(Optional.of(secondUser), userService.findById(2L));
    }

    @Test
    public void findAllUsersTest() {
        Assert.assertEquals(List.of(firstUser, secondUser), userService.findAll());
    }
}
