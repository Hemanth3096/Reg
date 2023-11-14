package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.User;

//UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByUsername(String username);

void save(org.springframework.boot.autoconfigure.security.SecurityProperties.User user);
}