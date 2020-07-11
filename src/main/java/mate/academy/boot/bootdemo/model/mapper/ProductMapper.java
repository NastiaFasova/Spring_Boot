package mate.academy.boot.bootdemo.model.mapper;

import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.Review;
import mate.academy.boot.bootdemo.model.dto.ProductDto;
import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        return product;
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        return productDto;
    }

    public Product getProductFromReviewLine(ReviewLineDto reviewLineDto) {
        Product product = new Product();
        product.setId(reviewLineDto.getProductId());
        return product;
    }
}
