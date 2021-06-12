package az.code.unisubscription.dto;

import az.code.unisubscription.models.Subscription;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class SubscriptionGetDTO {
    public SubscriptionGetDTO(Subscription subscription){
        id = subscription.getId();
        name = subscription.getName();
        nextBillingDate = subscription.getNextBillingDate();
        subscriptionDate = subscription.getSubscriptionDate();
        subscriptionMail = subscription.getSubscriptionMail();
        cost = subscription.getCost();
    }

    private int id;
    private String name;
    private String subscriptionMail;
    private LocalDate nextBillingDate;
    private double cost;
    private LocalDate  subscriptionDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(LocalDate nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
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
}
