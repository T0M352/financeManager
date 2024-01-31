package tomaszmorgas.financemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tomaszmorgas.financemanager.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
