package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {
    private AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext("mate.academy.boot.bootdemo");
    private final UserService userService = context.getBean(UserService.class);
    private final User firstUser = new User();
    private final User secondUser = new User();

    @Before
    public void setUp() {
        firstUser.setId("657784");
        secondUser.setId("65784");
        userService.save(firstUser);
        userService.save(secondUser);
    }

    @Test
    public void saveUserTest() {
        Assert.assertEquals(firstUser, userService.save(firstUser));
        Assert.assertEquals(secondUser, userService.save(secondUser));
    }

    @Test
    public void findUserById()   {
        Assert.assertEquals(Optional.of(firstUser), userService.findById("657784"));
        Assert.assertEquals(Optional.of(secondUser), userService.findById("65784"));
    }

    @Test
    public void findAllUsersTest() {
        Assert.assertEquals(List.of(firstUser, secondUser), userService.findAll());
    }
}
