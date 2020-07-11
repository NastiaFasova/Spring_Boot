package mate.academy.boot.bootdemo.model.dto;

import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Data;
import mate.academy.boot.bootdemo.model.Review;

@Data
public class UserDto {
    @NotNull
    private String profileName;
    private Set<Review> reviews;
}
