package proyecto_lenguajes.stm.Models;



import jakarta.persistence.*;
import lombok.*;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20, nullable = false)
    private String name;

    @Column( nullable = false)
    private String password;

}