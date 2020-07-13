package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RoleServiceTest {
    private RoleService roleService;
    private Role firstRole = new Role();
    private Role secondRole = new Role();

    @Before
    public void setUp() {
        roleService = Mockito.mock(RoleService.class);
        firstRole.setRoleName(Role.RoleName.ADMIN);
        secondRole.setRoleName(Role.RoleName.USER);
    }

    @Test
    public void saveRoleTest() {
        Mockito.when(roleService.save(firstRole)).thenReturn(firstRole);
        Mockito.when(roleService.save(secondRole)).thenReturn(secondRole);
    }

    @Test
    public void getRoleByNameTest() {
        Mockito.when(roleService.getRoleByName("ADMIN")).thenReturn(firstRole);
        Mockito.when(roleService.getRoleByName("USER")).thenReturn(secondRole);
    }

}
