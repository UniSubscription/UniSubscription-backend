package az.code.unisubscription.dao;

import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubscriptionDataDao implements SubscriptionDao{

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.getAllSubscriptions();
    }

    @Override
    public Subscription get(int id) {
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if (!subscription.isEmpty()) return subscription.get();
        return null;
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(int id, Subscription student) {
        Subscription subscription = get(id);
        if (subscription == null) return null;
        subscription.setId(id);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    @Override
    public Subscription deleteSubscription(int id) {
        Subscription subscription = get(id);
        if (subscription == null) return null;
        subscriptionRepository.delete(subscription);
        return subscription;
    }
}
