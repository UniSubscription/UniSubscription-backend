package az.code.unisubscription.dao;

import az.code.unisubscription.models.Subscription;

import java.util.List;

public interface SubscriptionDao {
    List<Subscription> getAll();
    Subscription get(int id);
    Subscription addSubscription(Subscription student);
    Subscription updateSubscription(int id, Subscription student);
    Subscription deleteSubscription(int id);
}
