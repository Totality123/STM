package proyecto_lenguajes.stm.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proyecto_lenguajes.stm.Model.User;
import proyecto_lenguajes.stm.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    
      @Autowired
    private UserRepository userRepository;

    public User add(User User) {
        return userRepository.save(User);
    }

    public List<User> get() {
        return userRepository.findAll();
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User update(int id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new RuntimeException("proyecto no encontrado con ID: " + id);
        }
    }
}

