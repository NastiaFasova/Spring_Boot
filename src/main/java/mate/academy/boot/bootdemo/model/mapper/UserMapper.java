package mate.academy.boot.bootdemo.model.mapper;

import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto getUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setProfileName(user.getProfileName());
        userDto.setReviews(user.getReviews());
        return userDto;
    }

    public User getUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setProfileName(userDto.getProfileName());
        user.setReviews(userDto.getReviews());
        return user;
    }
}
