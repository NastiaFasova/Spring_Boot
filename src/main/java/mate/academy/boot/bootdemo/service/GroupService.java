package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.Group;
import mate.academy.boot.bootdemo.model.Speciality;

public interface GroupService {
    Group save(Group group);

    Group getById(String id);
}
