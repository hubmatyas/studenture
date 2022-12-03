package net.studenture.api.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    //
     @Column(name = "password", nullable = false)
     private String password;

    //@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    //@CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id"))
    //@Enumerated(EnumType.STRING)
   // private Set<Role> roles;

    public User(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {

    }


}
