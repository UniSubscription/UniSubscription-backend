package az.code.unisubscription.services;

import az.code.unisubscription.dao.SubscriptionDao;
import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.utils.DtoUtil;
import az.code.unisubscription.utils.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements ISubscriptionService{

    SubscriptionDao dao;

    public SubscriptionService(SubscriptionDao dao){
        this.dao = dao;
    }

    @Override
    public Pageable<SubscriptionGetDTO> getAll(Integer size, int page) {
        List<SubscriptionGetDTO> subscriptions = DtoUtil.convertToSubscriptionDto(dao.getAll());
        return new Pageable<SubscriptionGetDTO>(subscriptions, page, size);
    }

    @Override
    public SubscriptionGetDTO addSubscription(Subscription subscription) {
        return new SubscriptionGetDTO(dao.addSubscription(subscription));
    }

    @Override
    public SubscriptionGetDTO updateSubscription(int id, Subscription subscription) {
        return new SubscriptionGetDTO(dao.updateSubscription(id, subscription));
    }

    @Override
    public SubscriptionGetDTO deleteSubscription(int id) {
        return new SubscriptionGetDTO(dao.deleteSubscription(id));
    }
}
