package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.Role;
import mate.academy.boot.bootdemo.repository.RoleRepository;
import mate.academy.boot.bootdemo.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getRoleByName(roleName).orElseThrow();
    }
}
