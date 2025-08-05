package kamol.cyber.portfolio_web.entity;

import jakarta.persistence.*;
import kamol.cyber.portfolio_web.entity.enums.RoleName;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, name = "role_name") // <- O'zgarish shu yerda
    private RoleName roleName;
}