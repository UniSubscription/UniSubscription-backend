package az.code.unisubscription.services;

import az.code.unisubscription.models.User;

public interface IEmailService {
    void sendMail(User user, String subject, String text);
}
