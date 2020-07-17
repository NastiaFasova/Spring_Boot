package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    void deleteById(Long id);

    @Query("SELECT r FROM Review r where r.id = :id AND r.internetUser.login = :login")
    Review findByIdAndUserLogin(Long id, String login);

}
