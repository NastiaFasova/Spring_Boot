package mate.academy.boot.bootdemo.service;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(String id);

    List<Product> getMostCommentedProducts(int limit);
}
