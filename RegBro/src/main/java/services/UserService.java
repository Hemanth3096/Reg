package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.User;
import repositories.UserRepository;

@Service
public class UserService {
 @Autowired
 private UserRepository userRepository;

 public Optional<User> findByUsername(String username) {
     return userRepository.findByUsername(username);
 }

 public void saveUser(org.springframework.boot.autoconfigure.security.SecurityProperties.User user) {
     userRepository.save(user);
 }
}