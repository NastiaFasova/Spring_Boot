package mate.academy.boot.bootdemo.model.dto;

import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Data;
import mate.academy.boot.bootdemo.model.Review;

@Data
public class InternetUserDto {
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Set<Review> reviews;
}
