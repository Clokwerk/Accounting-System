package accountingsystem.main.service;

import accountingsystem.main.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    List<Product> findByNameLike(String name);
    Product save(String description,String name,Long price,String date);
    Product deleteById(Long Id);
}
