package az.code.unisubscription.dtos;

import az.code.unisubscription.models.Subscription;

import java.time.LocalDateTime;

public class SubscriptionDTO {
    public SubscriptionDTO(Subscription subscription){
        id = subscription.getId();
        name = subscription.getName();
        nextExpire = subscription.getMonthlyDate();
        isActive = subscription.isActive();
        expireDate = subscription.getExpireDate();
    }

    private int id;
    private String name;
    private LocalDateTime nextExpire;
    private boolean isActive;
    private LocalDateTime  expireDate;

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

    public LocalDateTime getNextExpire() {
        return nextExpire;
    }

    public void setNextExpire(LocalDateTime nextExpire) {
        this.nextExpire = nextExpire;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
