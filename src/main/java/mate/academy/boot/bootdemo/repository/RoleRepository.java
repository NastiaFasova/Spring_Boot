package mate.academy.boot.bootdemo.repository;

import java.util.Optional;
import mate.academy.boot.bootdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r where r.roleName = :roleName")
    Optional<Role> getRoleByName(@Param("roleName")Role.RoleName roleName);
}
