package kamol.cyber.portfolio_web.controller;

import jakarta.validation.Valid;
import kamol.cyber.portfolio_web.entity.ContactMessage;
import kamol.cyber.portfolio_web.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@Valid @RequestBody ContactMessage contactMessage) {
        emailService.sendContactEmail(contactMessage);
        return ResponseEntity.ok("Xabar muvaffaqiyatli yuborildi!");
    }
}
