package proyecto_lenguajes.stm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto_lenguajes.stm.Models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
     @Query(value = "CALL users_by_id(:id_proyecto)", nativeQuery = true)
    List<User> listByid(@Param("id_proyecto") int id_proyecto);

}
