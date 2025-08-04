package kamol.cyber.portfolio_web.repository;

import kamol.cyber.portfolio_web.entity.CV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<CV, Long> {
}