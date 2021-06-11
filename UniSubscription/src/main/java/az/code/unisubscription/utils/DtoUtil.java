package az.code.unisubscription.utils;

import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.dto.SubscriptionPutDto;
import az.code.unisubscription.models.Subscription;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DtoUtil {
    public static List<SubscriptionGetDTO> convertToSubscriptionDto(List<Subscription> subscriptions){
        List<SubscriptionGetDTO> subscriptionDTOS = new ArrayList<>();
        subscriptions.stream().forEach(s -> subscriptionDTOS.add(new SubscriptionGetDTO(s)));
        return subscriptionDTOS;
    }
    public static Subscription convertPostDtoToSubscription(SubscriptionPostDto subscriptionPostDto){
        return Subscription.builder().name(subscriptionPostDto.getName())
                .subscriptionMail(subscriptionPostDto.getSubscriptionMail())
                .subscriptionDate(subscriptionPostDto.getSubscriptionDate())
                .cost(subscriptionPostDto.getCost())
                .nextBillingDate(LocalDateTime.now()
                        .plusMonths(1)
                        .withDayOfMonth(subscriptionPostDto.getSubscriptionDate().getDayOfMonth())
                        .withHour(subscriptionPostDto.getSubscriptionDate().getHour())
                        .withMinute(subscriptionPostDto.getSubscriptionDate().getMinute())
                        .withSecond(subscriptionPostDto.getSubscriptionDate().getSecond())
                )
                .build();
    }

    public static Subscription convertPutDtoToSubscription(SubscriptionPutDto subscriptionPutDto){
        return Subscription.builder().name(subscriptionPutDto.getName())
                .subscriptionMail(subscriptionPutDto.getSubscriptionMail())
                .subscriptionDate(subscriptionPutDto.getSubscriptionDate())
                .cost(subscriptionPutDto.getCost())
                .nextBillingDate(subscriptionPutDto.getNextBillingDate())
                .build();
    }
}
