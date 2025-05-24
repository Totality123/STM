package proyecto_lenguajes.stm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import proyecto_lenguajes.stm.repository.UserRepository;
import proyecto_lenguajes.stm.Models.User;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.findByName("Alice").isEmpty()) {
            User admin = new User();
            admin.setName("Alice");
            admin.setPassword(passwordEncoder.encode("pass123"));
            userRepository.save( admin);
            System.out.println("✅ Usuario 'Alice' creado");
        }

        if (userRepository.findByName("Paco").isEmpty()) {
            User user = new User();
            user.setName("Paco");
            user.setPassword(passwordEncoder.encode("pass123"));
            userRepository.save(user);
            System.out.println("✅ Usuario 'Paco' creado");
        }
    }
}
