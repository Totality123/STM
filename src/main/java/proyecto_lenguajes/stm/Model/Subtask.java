package proyecto_lenguajes.stm.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subtask")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private int percentage;

    @Column(length = 40, nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "id_task")
    private Task task;

    @OneToMany(mappedBy = "subtask", cascade = CascadeType.ALL)
    private List<Comment> comments;

}

