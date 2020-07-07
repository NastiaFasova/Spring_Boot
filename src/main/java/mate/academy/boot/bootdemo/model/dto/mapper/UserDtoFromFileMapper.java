package mate.academy.boot.bootdemo.model.dto.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mate.academy.boot.bootdemo.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoFromFileMapper {

    public UserDto getUserDtoFromFile(String line) {
        UserDto userDto = new UserDto();
        String[] userData = line.split(",");
        userDto.setId(Long.valueOf(userData[0]));
        userDto.setProductId(userData[1]);
        userDto.setUserId(userData[2]);
        userDto.setProfileName(userData[3]);
        userDto.setHelpfulnessNumerator(Long.valueOf(userData[4]));
        userDto.setHelpfulnessDenominator(Long.valueOf(userData[5]));
        userDto.setScore(Long.valueOf(userData[6]));
        LocalDateTime time =
                Instant.ofEpochMilli(Long.parseLong(userData[7]))
                        .atZone(ZoneId.systemDefault()).toLocalDateTime();
        userDto.setTime(time);
        userDto.setSummary(userData[8]);
        userDto.setText(userData[9]);
        return userDto;
    }
}
