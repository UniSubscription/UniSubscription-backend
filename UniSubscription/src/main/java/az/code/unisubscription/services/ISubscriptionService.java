package az.code.unisubscription.services;

import az.code.unisubscription.dtos.SubscriptionDTO;
import az.code.unisubscription.utils.Pageable;

public interface ISubscriptionService {
    Pageable<SubscriptionDTO> getAll(Integer size , int page);
}
