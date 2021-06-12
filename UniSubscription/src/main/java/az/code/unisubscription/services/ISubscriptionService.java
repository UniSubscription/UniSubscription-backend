package az.code.unisubscription.services;

import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.dto.SubscriptionPutDto;
import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.utils.Pageable;

public interface ISubscriptionService {
    Pageable<SubscriptionGetDTO> getAll(int userId, Integer size , int page);
    SubscriptionGetDTO getById(int id);
    SubscriptionGetDTO addSubscription(int userId, SubscriptionPostDto subscription);
    SubscriptionGetDTO updateSubscription(int id, SubscriptionPutDto subscriptionDto);
    SubscriptionGetDTO deleteSubscription(int id);
    Subscription doneMonthlyPayment(int id);
}
