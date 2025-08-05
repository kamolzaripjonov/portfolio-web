package kamol.cyber.portfolio_web.repository;

import kamol.cyber.portfolio_web.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}