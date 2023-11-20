package com.handbook.handbookapi.user;

import com.handbook.handbookapi.common.AbstractEntity;
import com.handbook.handbookapi.user.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")})
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_users")
public class User extends AbstractEntity {

    @Column(name = "username", nullable = false)
    @NotBlank
    @Size(max = 20)
    private String username;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
