package kamol.cyber.portfolio_web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String fullname;
    private String username;
}
