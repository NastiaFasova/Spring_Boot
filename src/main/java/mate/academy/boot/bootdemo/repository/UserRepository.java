package mate.academy.boot.bootdemo.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select r.user from Review r")
    List<User> findAll();

    @Query("select r.user from Review r where r.user.id = :id")
    Optional<User> findById(String id);
}
