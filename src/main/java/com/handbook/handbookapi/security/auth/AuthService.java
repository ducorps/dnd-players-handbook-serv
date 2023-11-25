package com.handbook.handbookapi.security.auth;

import com.handbook.handbookapi.user.role.ERole;
import com.handbook.handbookapi.user.role.Role;
import com.handbook.handbookapi.user.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    RoleRepository roleRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void initRoles() {
        Role role = new Role();
        role.setName(ERole.ROLE_ADMIN);

        Role role2 = new Role();
        role2.setName(ERole.ROLE_USER);

        Role role3 = new Role();
        role3.setName(ERole.ROLE_MODERATOR);

        Set<Role> roles = Set.of(role, role2, role3);
        roleRepository.saveAll(roles);
    }
}
