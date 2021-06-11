package az.code.unisubscription.services;

import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.utils.Pageable;

public interface ISubscriptionService {
    Pageable<SubscriptionGetDTO> getAll(Integer size , int page);
    SubscriptionGetDTO addSubscription(Subscription subscription);
    SubscriptionGetDTO updateSubscription(int id, Subscription subscription);
    SubscriptionGetDTO deleteSubscription(int id);
}
