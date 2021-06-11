package az.code.unisubscription.services;

import az.code.unisubscription.dao.SubscriptionDao;
import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.dto.SubscriptionPutDto;
import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.models.User;
import az.code.unisubscription.repositories.SubscriptionRepository;
import az.code.unisubscription.repositories.UserRepository;
import az.code.unisubscription.utils.DtoUtil;
import az.code.unisubscription.utils.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService{

    SubscriptionDao dao;

    @Autowired
    UserRepository repository;

    public SubscriptionService(SubscriptionDao dao){
        this.dao = dao;
    }

    @Override
    public Pageable<SubscriptionGetDTO> getAll(Integer size, int page) {
        List<SubscriptionGetDTO> subscriptions = DtoUtil.convertToSubscriptionDto(dao.getAll());
        return new Pageable<>(subscriptions, page, size);
    }

    @Override
    public SubscriptionGetDTO addSubscription(SubscriptionPostDto subscriptionDto) {
        Subscription subscription = DtoUtil.convertPostDtoToSubscription(subscriptionDto);
        User user = repository.findById(1).get();
        subscription.setUser(user);
        return new SubscriptionGetDTO(dao.addSubscription(subscription));
    }

    @Override
    public SubscriptionGetDTO updateSubscription(int id, SubscriptionPutDto subscriptionDto) {
        Subscription subscription = DtoUtil.convertPutDtoToSubscription(subscriptionDto);
        return new SubscriptionGetDTO(dao.updateSubscription(id, subscription));
    }

    @Override
    public SubscriptionGetDTO deleteSubscription(int id) {
        return new SubscriptionGetDTO(dao.deleteSubscription(id));
    }

    @Override
    public Subscription doneMonthlyPayment(int id) {
        return dao.doneMonthlyPayment(id);
    }
}
