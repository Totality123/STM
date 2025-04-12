package proyecto_lenguajes.stm.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private int percentage;

    @Column(length = 40, nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean completed;

    //FK PROYECTO 

}
