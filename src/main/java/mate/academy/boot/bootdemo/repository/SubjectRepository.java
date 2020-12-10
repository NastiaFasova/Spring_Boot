package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
