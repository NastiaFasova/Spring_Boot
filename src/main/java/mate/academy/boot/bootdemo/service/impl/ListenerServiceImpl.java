package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.Listener;
import mate.academy.boot.bootdemo.repository.ListenerRepository;
import mate.academy.boot.bootdemo.service.ListenerService;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl implements ListenerService {
    private final ListenerRepository listenerRepository;

    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public Listener save(Listener listener) {
        return listenerRepository.save(listener);
    }

    @Override
    public Listener getByEmail(String email) {
        return listenerRepository.findByEmail(email);
    }
}
