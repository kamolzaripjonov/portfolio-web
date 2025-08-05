package kamol.cyber.portfolio_web.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactMessage {
    @NotBlank(message = "Ism-sharif bo'sh bo'lishi mumkin emas")
    private String name;

    @NotBlank(message = "Email bo'sh bo'lishi mumkin emas")
    @Email(message = "Noto'g'ri email formatida kiritilgan")
    private String email;

    @NotBlank(message = "Xabar bo'sh bo'lishi mumkin emas")
    private String message;
}