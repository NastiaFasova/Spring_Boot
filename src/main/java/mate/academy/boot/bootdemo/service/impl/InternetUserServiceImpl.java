package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.repository.InternetUserRepository;
import mate.academy.boot.bootdemo.service.InternetUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class InternetUserServiceImpl implements InternetUserService {
    private static final Logger LOGGER = Logger.getLogger(InternetUserServiceImpl.class);
    private final InternetUserRepository internetUserRepository;

    public InternetUserServiceImpl(InternetUserRepository internetUserRepository) {
        this.internetUserRepository = internetUserRepository;
    }

    @Override
    public InternetUser getByEmail(String email) {
        LOGGER.info("The user with the email" + email + " was successfully retrieved from the db");
        return internetUserRepository.findByLogin(email);
    }

    @Override
    public InternetUser save(InternetUser user) {
        LOGGER.info("The user was saved into db");
        return internetUserRepository.save(user);
    }
}
