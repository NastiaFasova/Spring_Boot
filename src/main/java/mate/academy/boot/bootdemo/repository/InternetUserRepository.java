package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.InternetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetUserRepository extends JpaRepository<InternetUser, Long> {

    @Query("SELECT u FROM InternetUser u LEFT JOIN FETCH u.roles Role where u.login = :login")
    InternetUser findByLogin(String login);
}
