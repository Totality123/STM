package proyecto_lenguajes.stm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import proyecto_lenguajes.stm.repository.UserRepository;
import proyecto_lenguajes.stm.Models.User;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
                   .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
