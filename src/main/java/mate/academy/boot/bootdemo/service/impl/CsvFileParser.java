package mate.academy.boot.bootdemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import mate.academy.boot.bootdemo.model.dto.UserDto;
import mate.academy.boot.bootdemo.model.dto.mapper.UserDtoFromFileMapper;
import mate.academy.boot.bootdemo.service.FileParser;
import org.springframework.stereotype.Service;

@Service
public class CsvFileParser implements FileParser {
    private final UserDtoFromFileMapper mapper;

    public CsvFileParser(UserDtoFromFileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> parse(List<String> usersData) {
        List<UserDto> users = new ArrayList<>();
        for (String user : usersData) {
            users.add(mapper.getUserDtoFromFile(user));
        }
        return users;
    }
}
