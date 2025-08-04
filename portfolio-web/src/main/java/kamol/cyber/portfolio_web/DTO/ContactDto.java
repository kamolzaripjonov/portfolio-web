package kamol.cyber.portfolio_web.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDto {
    private Long id;
    private String fullName;
    private String email;
    private String subject;
    private String message;
}
