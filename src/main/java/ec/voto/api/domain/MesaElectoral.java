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

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "mesa_electoral")
public class MesaElectoral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(columnDefinition = "DATE DEFAULT current_date")
    private Timestamp fecha;

    @Column(name = "firma_asistencia", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean firmaAsistencia;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "grado_id")
    private Grado grado;

}
