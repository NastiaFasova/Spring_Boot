package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.repository.ProductRepository;
import mate.academy.boot.bootdemo.service.ProductService;
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
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
