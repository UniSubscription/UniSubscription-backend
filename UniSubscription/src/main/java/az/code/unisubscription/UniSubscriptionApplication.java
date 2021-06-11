package az.code.unisubscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class UniSubscriptionApplication {

    public static void main(String[] args) {
//        Timer timer = new Timer();
//        TimerTask

//        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        SpringApplication.run(UniSubscriptionApplication.class, args);
    }

}
