package mate.academy.boot.bootdemo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.model.dto.UserDto;
import mate.academy.boot.bootdemo.model.mapper.UserMapper;
import mate.academy.boot.bootdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/most-active")
    public List<UserDto> getMostActiveUsers(@RequestParam(name = "page", required = false,
            defaultValue = "0") int page, @RequestParam(name = "limit", required = false,
            defaultValue = "1000") int limit) {
        List<User> users = userService.findActiveUsers(page, limit);
        return users.stream()
                .map(userMapper::getUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/user")
    public UserDto getUserById(@RequestParam(name = "id") String id) {
        return userMapper.getUserDto(userService.findById(id).orElseThrow());
    }

    @GetMapping
    public List<UserDto> getUsers() {
        List<User> users = userService.findAll();
        return users.stream()
                .map(userMapper::getUserDto)
                .collect(Collectors.toList());
    }
}
