package ec.voto.api.dto;

import ec.voto.api.domain.Estudiante;
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

    private Estudiante estudiante;

    private PartidoDTO partido;

}
