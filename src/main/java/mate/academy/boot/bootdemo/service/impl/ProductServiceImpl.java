package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.repository.ProductRepository;
import mate.academy.boot.bootdemo.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final EntityManager manager;

    public ProductServiceImpl(ProductRepository productRepository, EntityManager manager) {
        this.productRepository = productRepository;
        this.manager = manager;
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
    public List<Product> getMostCommentedProducts(int limit) {
        return manager.createQuery("SELECT new Product(p.id) FROM Product p "
                + "GROUP BY p.id ORDER BY COUNT(p.id) desc", Product.class)
                .setMaxResults(limit).getResultList();
    }
}
