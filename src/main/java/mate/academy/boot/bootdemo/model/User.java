package mate.academy.boot.bootdemo.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String profileName;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(length = 50000)
    private Set<String> reviews;

    public User(String id) {
        this.id = id;
    }

    public User(String id, String profileName) {
        this.id = id;
        this.profileName = profileName;
    }
}
