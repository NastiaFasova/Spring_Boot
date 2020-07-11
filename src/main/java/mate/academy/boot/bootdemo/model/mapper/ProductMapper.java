package mate.academy.boot.bootdemo.model.mapper;

import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.model.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

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

}
