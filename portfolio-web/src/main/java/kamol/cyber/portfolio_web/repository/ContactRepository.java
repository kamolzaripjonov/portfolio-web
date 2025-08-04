package kamol.cyber.portfolio_web.repository;

import kamol.cyber.portfolio_web.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
