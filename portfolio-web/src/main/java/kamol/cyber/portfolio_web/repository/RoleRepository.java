package kamol.cyber.portfolio_web.repository;

import kamol.cyber.portfolio_web.entity.Role;
import kamol.cyber.portfolio_web.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName name);
}