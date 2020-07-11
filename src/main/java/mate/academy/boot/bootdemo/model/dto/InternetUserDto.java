package mate.academy.boot.bootdemo.model.dto;

import lombok.Data;
import mate.academy.boot.bootdemo.model.Review;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class InternetUserDto {
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Set<Review> reviews;
}
