package az.code.unisubscription.dao;

import az.code.unisubscription.models.User;
import az.code.unisubscription.repositories.SubscriptionRepository;
import az.code.unisubscription.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataDao implements UserDao{

    @Autowired
    UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }
}
