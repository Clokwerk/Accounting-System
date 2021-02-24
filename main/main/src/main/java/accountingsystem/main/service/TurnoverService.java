package accountingsystem.main.service;

import accountingsystem.main.model.Turnover;

import java.util.List;

public interface TurnoverService {
    List<Turnover> findAll();
    Turnover findById(Long id);

    Turnover save(String date, Long price, Integer numberProducts, Long sumProfit);
    Turnover deleteById(Long Id);
}
