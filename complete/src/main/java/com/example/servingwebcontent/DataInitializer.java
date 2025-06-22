package com.example.servingwebcontent;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // findByUsername trả về Optional<User>
            if (userRepository.findByUsername("admin").isEmpty()) { // đúng, vì Optional có isEmpty()
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // mã hóa mật khẩu
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
            }
        };
    }
}



