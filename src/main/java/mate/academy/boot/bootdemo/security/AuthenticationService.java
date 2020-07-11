package mate.academy.boot.bootdemo.security;

import mate.academy.boot.bootdemo.exception.AuthenticationException;
import mate.academy.boot.bootdemo.model.InternetUser;

public interface AuthenticationService {

    InternetUser login(String email, String password) throws AuthenticationException;

    InternetUser register(String email, String password) throws AuthenticationException;
}
