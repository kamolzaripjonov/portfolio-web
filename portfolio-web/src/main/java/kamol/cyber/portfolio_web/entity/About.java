package kamol.cyber.portfolio_web.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Entity
@Table(name = "abouts")
@Data
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String imageUrl;
}