package kamol.cyber.portfolio_web.DTO;

import lombok.Data;

@Data
public class AboutRequestDto {
    private String title;
    private String description;
    private String imageUrl;
    private String language;
}
