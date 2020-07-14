package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.Role;
import mate.academy.boot.bootdemo.repository.RoleRepository;
import mate.academy.boot.bootdemo.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        LOGGER.info("The role was successfully saved into the db");
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        LOGGER.info("The role with name " + roleName + " was successfully retrieved from the db");
        return roleRepository.getRoleByName(Role.RoleName.valueOf(roleName)).orElseThrow();
    }
}
