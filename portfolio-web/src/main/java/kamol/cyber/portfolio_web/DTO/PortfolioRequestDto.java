package kamol.cyber.portfolio_web.DTO;

import lombok.Data;

@Data
public class PortfolioRequestDto {
    private String title;
    private String description;
    private String imageUrl;
    private String link;
    private String language;
}
