package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getRoleByName(String roleName);
}
