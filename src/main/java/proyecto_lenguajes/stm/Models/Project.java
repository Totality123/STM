package proyecto_lenguajes.stm.Models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 0, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private Date date;

  
}
