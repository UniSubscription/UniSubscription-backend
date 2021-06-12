package az.code.unisubscription.services;

import az.code.unisubscription.models.User;

public interface IEmailService {
    void sendMail(String email, String subject, String text);
}
