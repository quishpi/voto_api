package ec.voto.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private String nombres;

    @Column(unique = true)
    private String email;

    @Column(name = "firma_asistencia")
    private Boolean firmaAsistencia;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "grado_id")
    private Curso grado;

}
