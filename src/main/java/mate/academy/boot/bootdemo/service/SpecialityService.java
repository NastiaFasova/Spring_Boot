package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.Role;
import mate.academy.boot.bootdemo.model.Speciality;

public interface SpecialityService {
    Speciality save(Speciality speciality);

    Speciality getById(String id);
}
