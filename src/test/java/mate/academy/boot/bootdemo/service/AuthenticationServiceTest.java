package mate.academy.boot.bootdemo.service;

import static org.mockito.Mockito.when;

import java.util.Set;
import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.model.Role;
import mate.academy.boot.bootdemo.security.AuthenticationServiceImpl;
import mate.academy.boot.bootdemo.service.impl.InternetUserServiceImpl;
import mate.academy.boot.bootdemo.service.impl.RoleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {
    @Mock
    private InternetUserServiceImpl internetUserService;
    @Mock
    private RoleServiceImpl roleService;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;
    private InternetUser userFromDb;

    @Test
    public void loginTest() {
        userFromDb = new InternetUser();
        String password = "1111";
        userFromDb.setUsername("bob");
        userFromDb.setPassword(password);
        when(internetUserService.getByEmail("bob")).thenReturn(userFromDb);
        when(passwordEncoder.matches(password, userFromDb.getPassword())).thenReturn(true);
        Assert.assertNotNull(userFromDb);
        Assert.assertEquals(authenticationService.login("bob", password), userFromDb);
    }

    @Test
    public void registerTest() {
        InternetUser internetUser = new InternetUser();
        String email = "login";
        String password = "password";
        internetUser.setUsername(email);
        internetUser.setPassword(password);
        Role role = new Role();
        role.setRoleName(Role.RoleName.USER);
        internetUser.setRoles(Set.of(role));
        when(internetUserService.save(internetUser)).thenReturn(internetUser);
        when(roleService.getRoleByName("USER")).thenReturn(role);
        when(passwordEncoder.encode(password)).thenReturn(password);
        Assert.assertEquals(authenticationService.register(email, password), internetUser);
    }
}
