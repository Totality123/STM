package proyecto_lenguajes.stm.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(length = 20, nullable = false)
    private String image_url;

    //ID_SUBTAREA

    //ID_USUARIOS
}