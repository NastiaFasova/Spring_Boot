package mate.academy.boot.bootdemo.model.mapper;

import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import mate.academy.boot.bootdemo.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto getUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setProfileName(user.getProfileName());
        userDto.setReviews(user.getReviews());
        return userDto;
    }

    public User getUser(UserDto userDto) {
        User user = new User();
        user.setProfileName(userDto.getProfileName());
        user.setReviews(userDto.getReviews());
        return user;
    }

    public User getUserFromReviewLine(ReviewLineDto reviewLineDto) {
        User user = new User();
        user.setId(reviewLineDto.getUserId());
        user.setProfileName(reviewLineDto.getProfileName());
        return user;
    }
}
