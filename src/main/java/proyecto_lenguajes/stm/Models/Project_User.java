package proyecto_lenguajes.stm.Models;

import jakarta.persistence.*;
//import lombok.Data;
import lombok.*;

@Entity
@Table(name = "project_user")

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Project_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @Column(nullable = false)
    private boolean admin;

    @Column(nullable = false)
    private int points;

}