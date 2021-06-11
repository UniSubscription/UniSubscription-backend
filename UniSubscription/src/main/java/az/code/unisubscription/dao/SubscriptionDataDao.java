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
    public List<Subscription> getAll(int userId) {
        return subscriptionRepository.getAllSubscriptions(userId);
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
    public Subscription updateSubscription(int id, Subscription subscriptionDto) {
        Subscription subscription = get(id);
        if (subscription == null) return null;
        subscription.setId(id);
        subscription.setName(subscriptionDto.getName());
        subscription.setSubscriptionMail(subscriptionDto.getSubscriptionMail());
        subscription.setSubscriptionDate(subscriptionDto.getSubscriptionDate());
        subscription.setNextBillingDate(subscriptionDto.getNextBillingDate());
        subscription.setCost(subscriptionDto.getCost());
        subscriptionRepository.save(subscription);
        return subscription;
    }

    @Override
    public Subscription deleteSubscription(int id) {
        Subscription subscription = get(id);
        if (subscription == null) return null;
        subscription.setDeleted(true);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    @Override
    public Subscription doneMonthlyPayment(int id) {
        Subscription subscription = get(id);
        if (subscription == null) return null;
        subscription.setPaymentDone(true);
        subscription.setNextBillingDate(subscription.getNextBillingDate().plusMonths(1));
        subscriptionRepository.save(subscription);
        return subscription;
    }
}
