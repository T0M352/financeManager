package tomaszmorgas.financemanager.service;

import tomaszmorgas.financemanager.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int theId);

    Product save(Product theProduct);

    void deleteById(int theId);
}
