package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.Listener;

public interface ListenerService {
    Listener save(Listener listener);

    Listener getByEmail(String email);
}
