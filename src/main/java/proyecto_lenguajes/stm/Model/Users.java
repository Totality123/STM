package proyecto_lenguajes.stm.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String password;
}

