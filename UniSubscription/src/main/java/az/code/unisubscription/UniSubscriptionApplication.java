package az.code.unisubscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UniSubscriptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniSubscriptionApplication.class, args);
    }

}
