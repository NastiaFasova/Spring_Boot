package mate.academy.boot.bootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;
import mate.academy.boot.bootdemo.repository.ProductRepository;
import mate.academy.boot.bootdemo.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        LOGGER.info("The product was successfully saved into the db");
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        LOGGER.info("All the products were retrieved from the db");
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        LOGGER.info("The product with the id " + id + " was successfully retrieved from the db");
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getMostCommentedProducts(int page, int limit, String sortBy) {
        Sort sortByRequest = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, limit, sortByRequest);
        return productRepository.findAll(pageRequest).getContent();
    }
}
