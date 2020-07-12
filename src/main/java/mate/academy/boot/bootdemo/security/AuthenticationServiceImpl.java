package mate.academy.boot.bootdemo.security;

import java.util.Set;
import mate.academy.boot.bootdemo.exception.AuthenticationException;
import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.model.Role;
import mate.academy.boot.bootdemo.service.InternetUserService;
import mate.academy.boot.bootdemo.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final InternetUserService internetUserService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(InternetUserService internetUserService,
                                     RoleService roleService, PasswordEncoder passwordEncoder) {
        this.internetUserService = internetUserService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public InternetUser login(String email, String password) throws AuthenticationException {
        InternetUser userFromDb = internetUserService.getByEmail(email);
        if (userFromDb != null && passwordEncoder.matches(password, userFromDb.getPassword())) {
            return userFromDb;
        }
        throw new AuthenticationException("Wrong login or password");
    }

    @Override
    public InternetUser register(String email, String password) throws AuthenticationException {
        InternetUser newUser = new InternetUser();
        newUser.setLogin(email);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Role role = roleService.getRoleByName("USER");
        newUser.setRoles(Set.of(role));
        return internetUserService.save(newUser);
    }
}
