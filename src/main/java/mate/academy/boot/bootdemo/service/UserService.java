package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.User;

public interface UserService {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

}
