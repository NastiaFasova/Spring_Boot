package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.repository.ProductRepository;
import mate.academy.boot.bootdemo.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getMostCommentedProducts(int page, int limit) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return productRepository.findAll(pageRequest).getContent();
    }
}
