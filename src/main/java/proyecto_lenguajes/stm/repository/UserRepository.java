package proyecto_lenguajes.stm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import proyecto_lenguajes.stm.Models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
