package proyecto_lenguajes.stm.Models;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String password;
}

