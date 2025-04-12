package proyecto_lenguajes.stm.Model;

import jakarta.persistence.*;
//import lombok.Data;

@Entity
@Table(name = "project_users")
//@Data
public class Project_Users {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    //ID_USUARIO

    //ID_PROYECTO

    @Column(nullable = false)
    private boolean admin;

}