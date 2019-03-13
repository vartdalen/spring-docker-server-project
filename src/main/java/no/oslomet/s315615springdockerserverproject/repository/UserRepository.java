package no.oslomet.s315615springdockerserverproject.repository;

import no.oslomet.s315615springdockerserverproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail(String email);
}