package mate.academy.boot.bootdemo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.dto.ProductDto;
import mate.academy.boot.bootdemo.model.mapper.ProductMapper;
import mate.academy.boot.bootdemo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid ProductDto productDto) {
        productService.save(productMapper.getProduct(productDto));
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable String id) {
        return productMapper.getProductDto(productService.findById(id).orElseThrow());
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        List<Product> users = productService.findAll();
        return users.stream()
                .map(productMapper::getProductDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-commented-food-items")
    public List<ProductDto> getMostCommentedFood(@RequestParam(name = "limit", required = false,
            defaultValue = "0")int page, @RequestParam(name = "limit", required = false,
            defaultValue = "1000") int limit, @RequestParam(name = "sortBy", required = false,
            defaultValue = "id") String sortBy) {
        List<Product> products = productService.getMostCommentedProducts(page, limit, sortBy);
        return products.stream()
                .map(productMapper::getProductDto)
                .collect(Collectors.toList());
    }
}
