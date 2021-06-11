package az.code.unisubscription.dto;

import az.code.unisubscription.models.Subscription;

import java.time.LocalDateTime;

public class SubscriptionGetDTO {
    public SubscriptionGetDTO(Subscription subscription){
        id = subscription.getId();
        name = subscription.getName();
        nextBillingDate = subscription.getNextBillingDate();
        isPaymentDone = subscription.isPaymentDone();
        subscriptionDate = subscription.getSubscriptionDate();
        subscriptionMail = subscription.getSubscriptionMail();
        cost = subscription.getCost();
    }

    private int id;
    private String name;
    private String subscriptionMail;
    private LocalDateTime nextBillingDate;
    private double cost;
    private boolean isPaymentDone;
    private LocalDateTime  subscriptionDate;

    // sample getters and setters
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

    public LocalDateTime getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(LocalDateTime nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public boolean isPaymentDone() {
        return isPaymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        isPaymentDone = paymentDone;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
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
