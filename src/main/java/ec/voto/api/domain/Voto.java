package ec.voto.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "voto")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "partido_id")
    private Partido partido;

    @Column(name = "voto_nulo", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean votoNulo;

}
