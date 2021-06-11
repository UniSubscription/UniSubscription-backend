package az.code.unisubscription.services;

import az.code.unisubscription.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{

    private JavaMailSender javaMailSender;


    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendMail(User user, String subject, String text) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getMail());
        mail.setFrom("example@gmail.com");
        mail.setSubject(subject);
        mail.setText(text);

        javaMailSender.send(mail);

    }
}
