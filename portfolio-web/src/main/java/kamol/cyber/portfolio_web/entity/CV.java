package kamol.cyber.portfolio_web.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cv")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl; // CV fayl linki (masalan, S3 yoki statik link)
}
