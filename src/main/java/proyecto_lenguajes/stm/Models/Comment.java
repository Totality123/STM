package proyecto_lenguajes.stm.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String image_url;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_subtask")
    private Subtask subtask;
}