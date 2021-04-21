package no.oslomet.s315615springdockerserverproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude="ticket")
@ToString(exclude="ticket")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
    private Set<Ticket> ticket;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}
