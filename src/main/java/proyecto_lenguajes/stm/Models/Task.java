package proyecto_lenguajes.stm.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Task {

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
    @JoinColumn(name = "id_project")
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Subtask> subtasks;
}
