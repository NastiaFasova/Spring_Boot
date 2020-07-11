package mate.academy.boot.bootdemo.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.bootdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new Product(p.id) from Product p LEFT JOIN p.reviews")
    List<Product> findAll();

    @Query("select new Product(p.id) from Product p LEFT JOIN p.reviews WHERE p.id = ?1")
    Optional<Product> findById(String id);
}
