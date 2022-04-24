package com.example.kindergarten;

import com.example.kindergarten.model.User;
import com.example.kindergarten.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import java.util.Objects;

@SpringBootApplication
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = { "x-auth-token", "x-requested-with", "x-xsrf-token" })
public class KindergartenApplication implements CommandLineRunner {

    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(KindergartenApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        if (Objects.isNull(this.userRepository.findByUserName("user"))) {
            User user = new User("user", "user", "admin", "admin", "123456789",
                    "admin@kindergarten", passwordEncoder.encode("123456"), "ADMIN");
            this.userRepository.save(user);
        }
    }
}
