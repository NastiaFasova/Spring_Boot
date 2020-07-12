package mate.academy.boot.bootdemo.controllers;

import javax.validation.Valid;
import mate.academy.boot.bootdemo.exception.AuthenticationException;
import mate.academy.boot.bootdemo.model.dto.InternetUserDto;
import mate.academy.boot.bootdemo.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final AuthenticationService authenticationService;

    public RegistrationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public void addInternetUser(@RequestBody @Valid InternetUserDto internetUserDto)
            throws AuthenticationException {
        authenticationService.register(internetUserDto.getEmail(), internetUserDto.getPassword());
    }
}
