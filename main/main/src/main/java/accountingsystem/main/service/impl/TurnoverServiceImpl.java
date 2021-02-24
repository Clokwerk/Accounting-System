package accountingsystem.main.service.impl;

import accountingsystem.main.exceptions.TurnoverNotFoundException;
import accountingsystem.main.model.Turnover;
import accountingsystem.main.repository.TurnoverRepository;
import accountingsystem.main.service.TurnoverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoverServiceImpl implements TurnoverService {
    private final TurnoverRepository turnoverRepository;

    public TurnoverServiceImpl(TurnoverRepository turnoverRepository) {
        this.turnoverRepository = turnoverRepository;
    }

    @Override
    public List<Turnover> findAll() {
        return turnoverRepository.findAll();
    }

    @Override
    public Turnover findById(Long id) {

        return turnoverRepository.findById(id).orElseThrow(TurnoverNotFoundException::new);
    }


    @Override
    public Turnover save(String date, Long price, Integer numberProducts, Long sumProfit) {
        Turnover turnover = new Turnover(date,price,numberProducts,sumProfit);
        turnoverRepository.save(turnover);
        return turnover;
    }

    @Override
    public Turnover deleteById(Long Id) {
        Turnover turnover = turnoverRepository.findById(Id).orElseThrow(TurnoverNotFoundException::new);
        turnoverRepository.deleteById(Id);
        return turnover;
    }
}
