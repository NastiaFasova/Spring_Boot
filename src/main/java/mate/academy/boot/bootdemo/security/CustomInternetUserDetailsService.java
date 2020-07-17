package mate.academy.boot.bootdemo.security;

import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.service.InternetUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomInternetUserDetailsService implements UserDetailsService {
    private final InternetUserService internetUserService;

    public CustomInternetUserDetailsService(InternetUserService internetUserService) {
        this.internetUserService = internetUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        InternetUser user = internetUserService.getByEmail(email);
        User.UserBuilder userBuilder;
        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.password(user.getPassword());
            String[] roles = user.getRoles().stream()
                    .map(role -> role.getRoleName().name())
                    .toArray(String[]::new);
            userBuilder.roles(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return userBuilder.build();
    }
}
