package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.repository.UserRepository;
import mate.academy.boot.bootdemo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        LOGGER.info("User was added into db");
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        LOGGER.info("All the users were retrieved from the db");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        LOGGER.info("The user with the id " + id + " was successfully retrieved from the db");
        return userRepository.findById(id);
    }

    @Override
    public List<User> findActiveUsers(int page, int limit, String sortBy) {
        Sort sortByRequest = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, limit, sortByRequest);
        return userRepository.findAll(pageRequest).getContent();
    }

}
