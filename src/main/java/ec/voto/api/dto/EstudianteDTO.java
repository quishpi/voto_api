package ec.voto.api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class EstudianteDTO {

    private Long id;

    private String nombres;

    private String email;

    private Boolean firmaAsistencia;

    private CursoDTO curso;

}

