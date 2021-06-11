package az.code.unisubscription.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate expireDate;
    private LocalDate monthlyDate;
    private String platform;
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
