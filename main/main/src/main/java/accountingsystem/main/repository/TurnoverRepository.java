package accountingsystem.main.repository;

import accountingsystem.main.model.Turnover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TurnoverRepository extends JpaRepository<Turnover, Long> {

}
