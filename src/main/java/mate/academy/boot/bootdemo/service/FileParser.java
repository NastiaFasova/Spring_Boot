package mate.academy.boot.bootdemo.service;

import java.util.List;
import mate.academy.boot.bootdemo.model.dto.UserDto;

public interface FileParser {
    List<UserDto> parse(List<String> fileData);
}
