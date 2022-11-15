package net.studenture.api.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name="user_role",joinColumns = @JoinColumn(name="userId"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

}
