package mate.academy.boot.bootdemo.model.mapper;

import java.util.Set;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.dto.ProductDto;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final ReviewLineMapper reviewLineMapper;

    public ProductMapper(ReviewLineMapper reviewLineMapper) {
        this.reviewLineMapper = reviewLineMapper;
    }

    public Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setReviews(productDto.getReviews());
        return product;
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setReviews(product.getReviews());
        return productDto;
    }

    public Product getProductFromReviewLine(ReviewLineDto reviewLineDto) {
        Product product = new Product();
        product.setId(reviewLineDto.getProductId());
        product.setReviews(Set.of(reviewLineDto.getText()));
        return product;
    }
}
