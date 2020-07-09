package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
