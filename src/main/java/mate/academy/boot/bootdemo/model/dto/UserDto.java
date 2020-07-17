package mate.academy.boot.bootdemo.model.dto;

import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
    @NotNull
    private String profileName;
    private Set<String> reviews;
}
