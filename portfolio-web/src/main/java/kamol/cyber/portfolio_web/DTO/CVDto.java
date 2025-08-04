package kamol.cyber.portfolio_web.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CVDto {
    private Long id;
    private String fileName;
    private String fileType;
    private MultipartFile file;
}