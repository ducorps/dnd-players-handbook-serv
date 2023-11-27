package com.handbook.handbookapi.user;

import com.handbook.handbookapi.user.role.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public static UserDTO fromEntity(User user) {
        if (Objects.isNull(user)) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRoles(user.getRoles());

        return dto;
    }

    public User toEntity() {
        User user = new User();
        user.setUsername(this.getUsername());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        user.setRoles(this.getRoles());

        return user;
    }
}
