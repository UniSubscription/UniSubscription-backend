package az.code.unisubscription.services;

import az.code.unisubscription.dao.SubscriptionDao;
import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.dto.SubscriptionPutDto;
import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.models.User;
import az.code.unisubscription.repositories.UserRepo;
import az.code.unisubscription.utils.DtoUtil;
import az.code.unisubscription.utils.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements ISubscriptionService{

    SubscriptionDao dao;

    @Autowired
    UserRepo repository;

    public SubscriptionService(SubscriptionDao dao){
        this.dao = dao;
    }

    @Override
    public Pageable<SubscriptionGetDTO> getAll(int userId, Integer size, int page) {
        List<SubscriptionGetDTO> subscriptions = DtoUtil.convertToSubscriptionDto(dao.getAll(userId));
        return new Pageable<>(subscriptions, page, size);
    }

    @Override
    public SubscriptionGetDTO getById(int id) {
        return new SubscriptionGetDTO(dao.get(id));
    }

    @Override
    public SubscriptionGetDTO addSubscription(int userId, SubscriptionPostDto subscriptionDto) {
        Subscription subscription = DtoUtil.convertPostDtoToSubscription(subscriptionDto);
        User user = repository.findById(userId).get();
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
