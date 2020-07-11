package mate.academy.boot.bootdemo.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name =  "user_id")
    private String id;
    private String profileName;
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    public User(String id) {
        this.id = id;
    }

    public User(String id, String profileName) {
        this.id = id;
        this.profileName = profileName;
    }
}
