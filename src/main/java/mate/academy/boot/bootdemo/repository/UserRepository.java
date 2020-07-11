package mate.academy.boot.bootdemo.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select new User(u.id) from User u LEFT JOIN u.reviews")
    List<User> findAll();

    @Query("select new User(u.id) from User u LEFT JOIN u.reviews WHERE u.id = ?1")
    Optional<User> findById(String id);
}
