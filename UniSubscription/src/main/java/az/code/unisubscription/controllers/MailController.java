package az.code.unisubscription.controllers;

import az.code.unisubscription.models.User;
import az.code.unisubscription.services.IEmailService;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendmail")
public class MailController {
    IEmailService emailService;

    public MailController(IEmailService emailService) {
        this.emailService = emailService;
    }
    @GetMapping
    public void sendMessage(){
        User user = new User();
        user.setId(1);
        user.setActive(true);
        user.setName("Amrah");
        user.setSurname("Ahmadov");
        user.setMail("ahmadovamrah906@gmail.com");
        emailService.sendMail(user, "Welcome", "you signed up successfull");
    }
}
