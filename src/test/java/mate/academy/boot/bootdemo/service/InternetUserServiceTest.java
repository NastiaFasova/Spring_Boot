package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.InternetUser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class InternetUserServiceTest {
    private InternetUserService internetUserService;
    InternetUser user = new InternetUser();

    @Before
    public void setUp() {
        internetUserService = Mockito.mock(InternetUserService.class);
        user.setLogin("user");
    }

    @Test
    public void saveUserTest() {

    }

    @Test
    public void getByEmailTest() {

    }
}
