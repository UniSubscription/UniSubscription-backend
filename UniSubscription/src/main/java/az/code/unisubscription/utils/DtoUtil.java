package az.code.unisubscription.utils;

import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.models.Subscription;

import java.util.ArrayList;
import java.util.List;

public class DtoUtil {
    public static List<SubscriptionGetDTO> convertToSubscriptionDto(List<Subscription> subscriptions){
        List<SubscriptionGetDTO> subscriptionDTOS = new ArrayList<>();
        subscriptions.stream().forEach(s -> subscriptionDTOS.add(new SubscriptionGetDTO(s)));
        return subscriptionDTOS;
    }
}
