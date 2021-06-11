package az.code.unisubscription.repositories;

import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    User getUserByMail(String username);
}
