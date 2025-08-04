package kamol.cyber.portfolio_web.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String fullname;

    @Column(nullable = false)
    private String password;

    private String role; // "ADMIN" yoki boshqa rollar

    private boolean enabled = true;
}
