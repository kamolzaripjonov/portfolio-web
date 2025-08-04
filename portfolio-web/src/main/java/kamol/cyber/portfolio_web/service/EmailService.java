package kamol.cyber.portfolio_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMessage(String from, String name, String messageText) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // foydalanuvchi emaili
        message.setTo("sizningemailingiz@gmail.com");
        message.setSubject("Portfolio orqali xabar: " + name);
        message.setText("Ismi: " + name + "\nEmail: " + from + "\n\nXabar:\n" + messageText);
        mailSender.send(message);
    }
}
