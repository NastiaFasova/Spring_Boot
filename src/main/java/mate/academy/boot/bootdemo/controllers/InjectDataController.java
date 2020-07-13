package mate.academy.boot.bootdemo.controllers;

import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import mate.academy.boot.bootdemo.model.InternetUser;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.Role;
import mate.academy.boot.bootdemo.model.User;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import mate.academy.boot.bootdemo.model.mapper.ProductMapper;
import mate.academy.boot.bootdemo.model.mapper.ReviewLineMapper;
import mate.academy.boot.bootdemo.model.mapper.UserMapper;
import mate.academy.boot.bootdemo.service.FileParser;
import mate.academy.boot.bootdemo.service.FileReaderService;
import mate.academy.boot.bootdemo.service.InternetUserService;
import mate.academy.boot.bootdemo.service.ProductService;
import mate.academy.boot.bootdemo.service.ReviewService;
import mate.academy.boot.bootdemo.service.RoleService;
import mate.academy.boot.bootdemo.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class InjectDataController {

    private final RoleService roleService;

    private final InternetUserService internetUserService;

    private final FileReaderService fileReaderService;

    private final FileParser<List<ReviewLineDto>> fileParser;

    private final UserMapper userMapper;

    private final UserService userService;

    private final ReviewLineMapper reviewLineMapper;

    private final ReviewService reviewService;

    private final ProductMapper productMapper;

    private final ProductService productService;

    public InjectDataController(RoleService roleService, InternetUserService internetUserService,
                                FileReaderService fileReaderService,
                                FileParser<List<ReviewLineDto>> fileParser,
                                UserMapper userMapper, UserService userService,
                                ReviewLineMapper reviewLineMapper, ReviewService reviewService,
                                ProductMapper productMapper, ProductService productService) {
        this.roleService = roleService;
        this.internetUserService = internetUserService;
        this.fileReaderService = fileReaderService;
        this.fileParser = fileParser;
        this.userMapper = userMapper;
        this.userService = userService;
        this.reviewLineMapper = reviewLineMapper;
        this.reviewService = reviewService;
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @PostConstruct
    public void injectData() {
        injectUsers();
        List<String> data = fileReaderService.readFile("C:/Users/Reviews.csv");
        data.remove(0);
        List<ReviewLineDto> reviewDtos = fileParser.parse(data);
        for (ReviewLineDto reviewLineDto : reviewDtos) {
            User user = userMapper.getUserFromReviewLine(reviewLineDto);
            userService.save(user);
            Product product = productMapper.getProductFromReviewLine(reviewLineDto);
            productService.save(product);
            Review review = reviewLineMapper.getReviewFromLine(reviewLineDto);
            reviewService.save(review);
        }
    }

    private void injectUsers() {
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        InternetUser user = new InternetUser();

        user.setLogin("user@ukr.net");
        user.setPassword("1111");
        user.setRoles(Set.of(userRole));
        roleService.save(userRole);
        internetUserService.save(user);

        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        InternetUser admin = new InternetUser();
        admin.setLogin("admin@gmail.com");
        admin.setPassword("9999");
        admin.setRoles(Set.of(adminRole));
        roleService.save(adminRole);
        internetUserService.save(admin);
    }
}
