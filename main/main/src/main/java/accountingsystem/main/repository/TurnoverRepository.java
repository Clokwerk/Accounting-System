package accountingsystem.main.repository;

import accountingsystem.main.model.Turnover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TurnoverRepository extends JpaRepository<Turnover, Long> {
    public List<Turnover> findByNameLike(String name);
}
