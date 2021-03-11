package accountingsystem.main.service;

import accountingsystem.main.model.Company;
import accountingsystem.main.model.Product;
import accountingsystem.main.model.User;
import accountingsystem.main.model.WorkService;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> findAll();
    Optional<Company> findById(Long id);
    List<Company> findByNameLike(String name);
    Company save(
            String name,
            String founder,
            List<Product> products,
            List<WorkService> workServices,
            String address,
            String incorporationDate,
            String taxNumber,
            String registeredNumber,
            User user);
    Company deleteById(Long Id);
}
