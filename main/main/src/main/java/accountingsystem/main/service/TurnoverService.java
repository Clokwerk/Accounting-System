package accountingsystem.main.service;

import accountingsystem.main.model.Company;

import java.util.List;

public interface TurnoverService {
    List<Company> findAll();
    Company findById();
    List<Company> findByNameLike();
    Company save();
    Company delete();
}
