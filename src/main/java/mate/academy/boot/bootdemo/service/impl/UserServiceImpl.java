package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.repository.ProductRepository;
import mate.academy.boot.bootdemo.repository.UserRepository;
import mate.academy.boot.bootdemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public User save(User user) {
        productRepository.save(user.getProduct());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
