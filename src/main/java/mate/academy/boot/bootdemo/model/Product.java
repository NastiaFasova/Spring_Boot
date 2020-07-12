package mate.academy.boot.bootdemo.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @NotNull
    private String id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(length = 50000)
    private Set<String> reviews;

    public Product(String id) {
        this.id = id;
    }
}
