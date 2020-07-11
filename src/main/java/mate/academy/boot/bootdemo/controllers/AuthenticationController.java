package mate.academy.boot.bootdemo.controllers;

import mate.academy.boot.bootdemo.exception.AuthenticationException;
import mate.academy.boot.bootdemo.model.dto.InternetUserDto;
import mate.academy.boot.bootdemo.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public void addInternetUser(@RequestBody @Valid InternetUserDto internetUserDto)
            throws AuthenticationException {
        authenticationService.register(internetUserDto.getEmail(), internetUserDto.getPassword());
    }
}
