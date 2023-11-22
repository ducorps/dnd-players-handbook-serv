package com.handbook.handbookapi.user.refreshtoken;

import com.handbook.handbookapi.user.User;
import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>, CustomQuerydslPredicateExecutor<RefreshToken> {

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    Integer deleteByUser(User user);
}
