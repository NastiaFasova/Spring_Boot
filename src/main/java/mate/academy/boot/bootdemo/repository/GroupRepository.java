package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT g FROM Group g LEFT JOIN FETCH g.listeners Listener " +
            "LEFT JOIN FETCH Listener.roles where g.id = :id")
    Group findById(String id);
}
