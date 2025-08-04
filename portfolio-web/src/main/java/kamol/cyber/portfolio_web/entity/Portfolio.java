package kamol.cyber.portfolio_web.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "portfolios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private String imageUrl;

    private String githubLink;

    private String demoLink;

    @Column(columnDefinition = "TEXT")
    private String description;
}
