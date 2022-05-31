package com.etherofgodd.flight_reservation.repository;

import com.etherofgodd.flight_reservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
