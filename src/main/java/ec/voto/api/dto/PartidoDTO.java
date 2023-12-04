package ec.voto.api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class PartidoDTO {

    private Long id;

    private String candidato;

    private Long numPartido;

    private String nombrePartido;

}

