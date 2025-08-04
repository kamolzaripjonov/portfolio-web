package kamol.cyber.portfolio_web.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AboutResponseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}
