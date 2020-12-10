package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.Group;
import mate.academy.boot.bootdemo.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("SELECT l FROM Lesson l LEFT JOIN FETCH l.group group " +
            " where l.id = :id group by l.days order by l.time")
    List<Lesson> getAllLessonsByGroupId(String id);
}
