package mate.academy.boot.bootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Group group;
    @OneToMany
    private List<Day> days;
    private LocalTime time;
}
