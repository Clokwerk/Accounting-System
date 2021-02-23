package accountingsystem.main.service;

import accountingsystem.main.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    Manufacturer findById();
    List<Manufacturer> findByNameLike();
    Manufacturer save();
    Manufacturer delete();
}
