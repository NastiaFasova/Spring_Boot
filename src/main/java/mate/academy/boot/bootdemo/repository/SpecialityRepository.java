package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.Group;
import mate.academy.boot.bootdemo.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    @Query("SELECT s FROM Speciality s LEFT JOIN FETCH s.groups Group where s.id = :id")
    Speciality findById(String id);
}
