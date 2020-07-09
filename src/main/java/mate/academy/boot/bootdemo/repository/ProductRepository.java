package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
