package az.code.unisubscription.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class SubscriptionPutDto {
    private String name;
    private LocalDateTime subscriptionDate;
    private String subscriptionMail;
    private double cost;
    private LocalDateTime nextBillingDate;
//    private boolean isPaymentDone;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(LocalDateTime nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

//    public boolean isPaymentDone() {
//        return isPaymentDone;
//    }
//
//    public void setPaymentDone(boolean paymentDone) {
//        isPaymentDone = paymentDone;
//    }
}
