package mate.academy.boot.bootdemo.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select r.product from Review r")
    List<Product> findAll();

    @Query("select r.product from Review r where r.product.id = :id")
    Optional<Product> findById(String id);
}
