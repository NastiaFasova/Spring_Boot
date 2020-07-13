package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.security.AuthenticationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AuthenticationServiceTest {
    private AuthenticationService authenticationService;
    private InternetUserService internetUserService;
    private InternetUser bob;

    @Before
    public void setUp() {
        authenticationService = Mockito.mock(AuthenticationService.class);
        internetUserService = Mockito.mock(InternetUserService.class);
        InternetUser bob = new InternetUser();
        bob.setLogin("bob");
        bob.setPassword("1111");
    }

    @Test
    public void loginTest() {
        Mockito.when(internetUserService.getByEmail("bob")).thenReturn(bob);
        Assert.assertEquals(authenticationService.login("bob", "1111"), bob);
    }
}
