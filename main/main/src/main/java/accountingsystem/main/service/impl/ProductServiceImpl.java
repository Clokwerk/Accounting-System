package accountingsystem.main.service.impl;

import accountingsystem.main.exceptions.ProductNotFoundException;
import accountingsystem.main.model.Product;
import accountingsystem.main.repository.ProductRepository;
import accountingsystem.main.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
       return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return productRepository.findByNameLike(name);
    }

    @Override
    public Product save(String description, String name, Long price, String date) {
        Product product = new Product();
        product.setDescription(description);
        product.setName(name);
        product.setPrice(price);
        product.setDate(date);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product deleteById(Long Id) {
        Product product = productRepository.findById(Id).orElseThrow(ProductNotFoundException::new);
        productRepository.deleteById(Id);
        return product;
    }
}
