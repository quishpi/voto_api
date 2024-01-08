package ec.voto.api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "mesa")
    private MesaElectoral mesa;

}
