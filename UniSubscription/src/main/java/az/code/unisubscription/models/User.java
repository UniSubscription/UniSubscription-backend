package az.code.unisubscription.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Subscription> subscriptionList;
    private String name;
    private String surname;
    @Column(unique = true)
    private String mail;
    private String password;
    private boolean isActive;
    private LocalDateTime creationDate;
    private LocalDateTime deletedDate;
}
