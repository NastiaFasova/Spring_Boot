package mate.academy.boot.bootdemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import mate.academy.boot.bootdemo.model.dto.UserDto;
import mate.academy.boot.bootdemo.model.dto.mapper.UserDtoFromLinesMapper;
import mate.academy.boot.bootdemo.service.FileParser;
import org.springframework.stereotype.Service;

@Service
public class CsvLinesParser implements FileParser<List<UserDto>> {
    private final UserDtoFromLinesMapper mapper;

    public CsvLinesParser(UserDtoFromLinesMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> parse(List<String> usersData) {
        List<UserDto> users = new ArrayList<>();
        for (String user : usersData) {
            String[] userData = user.split(",");
            users.add(mapper.getUserDtoFromLines(userData));
        }
        return users;
    }
}
