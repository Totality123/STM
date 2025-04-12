package proyecto_lenguajes.stm.Model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(length = 0, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private Date date;
}
