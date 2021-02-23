package accountingsystem.main.service;

import accountingsystem.main.model.Company;
import accountingsystem.main.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById();
    List<Product> findByNameLike();
    Product save();
    Product delete();
}
