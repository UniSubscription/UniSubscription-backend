package az.code.unisubscription.utils;

import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.repositories.SubscriptionRepository;
import az.code.unisubscription.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MyScheduler {
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    IEmailService iEmailService;

    @Scheduled(cron = "0 0 23 * * ?", zone="Asia/Baku")
    public void expireDateSendMail(){
//        System.out.println("TESTTTTTTTTTTTTTTTTTTTt");
        List<Subscription> allSubscriptions = subscriptionRepository.getAllSubscriptions();
        for(Subscription s : allSubscriptions){
            LocalDate today = LocalDate.now();
//            System.out.println(today + " today");
            LocalDateTime expireDateLDT = s.getSubscriptionDate().plusMonths(1).minusDays(1);
            LocalDate expireDate =  expireDateLDT.toLocalDate();
//            System.out.println(expireDate + " expire date");
            if(expireDate.equals(today)){
                iEmailService.sendMail(s.getUser(), "Subscription expiring ", "Your subscription expiring Tomorrow " +  s.getSubscriptionDate().plusMonths(1).toString());
            }
        }
    }
}
