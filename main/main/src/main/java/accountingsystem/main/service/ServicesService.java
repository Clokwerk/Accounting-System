package accountingsystem.main.service;

import accountingsystem.main.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServicesService {
    List<Service> findAll();
    Service findById();
    List<Service> findByNameLike();
    Service save();
    Service delete();
}
