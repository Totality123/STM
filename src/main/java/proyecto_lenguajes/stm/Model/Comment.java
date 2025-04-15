package proyecto_lenguajes.stm.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "id_subtask")
    private Subtask subtask;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}