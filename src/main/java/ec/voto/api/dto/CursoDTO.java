package ec.voto.api.dto;

import ec.voto.api.domain.MesaElectoral;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class CursoDTO {

    private Long id;

    private String nombre;

    private MesaElectoral mesa;

}

