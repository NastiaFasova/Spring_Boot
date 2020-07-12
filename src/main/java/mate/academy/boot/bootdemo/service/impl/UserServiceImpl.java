package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.repository.UserRepository;
import mate.academy.boot.bootdemo.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findActiveUsers(int page, int limit) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return userRepository.findAll(pageRequest).getContent();
    }

}
