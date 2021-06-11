package az.code.unisubscription.repositories;

import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
