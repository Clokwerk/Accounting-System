package accountingsystem.main.service;

import accountingsystem.main.model.Company;
import accountingsystem.main.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Company> findAll();
    Optional<Company> findById(Long id);
    List<Company> findByNameLike(String name);
    Company save(String address,String founder,String incorporationDate,String taxNumber,String registeredNumber);
    Company deleteById(Long Id);
}
