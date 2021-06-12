package az.code.unisubscription.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String subscriptionMail;
    private LocalDate subscriptionDate;
    private LocalDate nextBillingDate;
    private double cost;
    private String platform;
    @Column(name = "isPaymentDone", columnDefinition = "boolean default false")
    private boolean isPaymentDone;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;
}
