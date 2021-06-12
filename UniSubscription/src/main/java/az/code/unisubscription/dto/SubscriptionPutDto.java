package az.code.unisubscription.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SubscriptionPutDto {
    private String name;
    private LocalDate subscriptionDate;
    private String subscriptionMail;
    private double cost;
    private LocalDate nextBillingDate;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getSubscriptionMail() {
        return subscriptionMail;
    }

    public void setSubscriptionMail(String subscriptionMail) {
        this.subscriptionMail = subscriptionMail;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(LocalDate nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }
}
