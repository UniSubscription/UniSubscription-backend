package az.code.unisubscription.repositories;

import az.code.unisubscription.models.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    @Query(value = "select * from Subscription WHERE is_deleted = false AND user_id = :userId ORDER BY id DESC",nativeQuery = true)
    List<Subscription> getAllSubscriptions(int userId);

    @Query(value = "select * from Subscription WHERE is_deleted = false ORDER BY id DESC",nativeQuery = true)
    List<Subscription> getAllSubscriptionsList();
}
