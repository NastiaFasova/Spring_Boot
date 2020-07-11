package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.repository.InternetUserRepository;
import mate.academy.boot.bootdemo.service.InternetUserService;
import org.springframework.stereotype.Service;

@Service
public class InternetUserServiceImpl implements InternetUserService {
    private final InternetUserRepository internetUserRepository;

    public InternetUserServiceImpl(InternetUserRepository internetUserRepository) {
        this.internetUserRepository = internetUserRepository;
    }

    @Override
    public InternetUser getByEmail(String email) {
        return internetUserRepository.findByLogin(email);
    }

    @Override
    public InternetUser save(InternetUser user) {
        return internetUserRepository.save(user);
    }
}
