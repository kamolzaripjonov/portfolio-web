package kamol.cyber.portfolio_web.controller;

import kamol.cyber.portfolio_web.DTO.ContactRequest;
import kamol.cyber.portfolio_web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*") // front bilan aloqani ruxsat etish
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody ContactRequest request) {
        emailService.sendMessage(request.getEmail(), request.getName(), request.getMessage());
        return ResponseEntity.ok("Xabar muvaffaqiyatli yuborildi!");
    }
}
