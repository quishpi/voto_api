package ec.voto.api.dto;

import ec.voto.api.domain.Estudiante;
import ec.voto.api.domain.MesaElectoral;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class VotoDTO {

    private Long id;

    private EstudianteDTO estudiante;

    private PartidoDTO partido;

    private MesaElectoralDTO mesa;

}
