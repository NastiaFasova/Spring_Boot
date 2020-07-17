package mate.academy.boot.bootdemo.model.dto;

import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
    @NotNull
    private String id;
    private Set<String> reviews;
}
