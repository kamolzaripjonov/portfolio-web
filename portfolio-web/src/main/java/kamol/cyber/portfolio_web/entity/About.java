package kamol.cyber.portfolio_web.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "about")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;
}
