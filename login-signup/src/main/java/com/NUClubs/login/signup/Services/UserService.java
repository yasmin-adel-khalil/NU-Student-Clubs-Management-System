package com.NUClubs.login.signup.Services;

import com.NUClubs.login.signup.Models.User;
import com.NUClubs.login.signup.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean register(String username, String email, String rawPassword) {
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email)) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encoder.encode(rawPassword));
        userRepository.save(user);
        return true;
    }

    public User authenticate(String username, String rawPassword) {
        Optional<User> opt = userRepository.findByUsername(username);
        if (opt.isEmpty()) return null;
        User user = opt.get();
        if (encoder.matches(rawPassword, user.getPassword())) {
            return user;
        }
        return null;
    }
}
