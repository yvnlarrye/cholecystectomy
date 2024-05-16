package com.cholecystectomy.config;

import com.cholecystectomy.domain.model.Admin;
import com.cholecystectomy.domain.model.Role;
import com.cholecystectomy.domain.model.Sex;
import com.cholecystectomy.domain.model.User;
import com.cholecystectomy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.countByRole(Role.ROLE_ADMIN) == 0) {
            User user = new Admin();
            user.setEmail("admin");
            user.setSex(Sex.MALE);
            user.setRole(Role.ROLE_ADMIN);
            user.setName("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            userRepository.save(user);
        }
    }
}
