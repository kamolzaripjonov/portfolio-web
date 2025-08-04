package kamol.cyber.portfolio_web.repository;

import kamol.cyber.portfolio_web.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutRepository extends JpaRepository<About, Long> {
    List<About> findAllByLanguage(String language);
}
