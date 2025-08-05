package kamol.cyber.portfolio_web.repository;

import kamol.cyber.portfolio_web.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}