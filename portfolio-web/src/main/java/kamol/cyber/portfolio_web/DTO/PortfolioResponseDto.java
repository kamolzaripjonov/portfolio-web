package kamol.cyber.portfolio_web.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioResponseDto {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String link;
    private String language;
}
