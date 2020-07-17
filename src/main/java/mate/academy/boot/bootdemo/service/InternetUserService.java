package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.InternetUser;

public interface InternetUserService {
    InternetUser getByEmail(String email);

    InternetUser save(InternetUser user);
}
