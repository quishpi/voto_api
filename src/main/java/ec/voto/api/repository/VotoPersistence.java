package ec.voto.api.repository;
import java.util.List;
import java.util.Optional;

import ec.voto.api.domain.Curso;
import ec.voto.api.domain.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Voto;

public interface VotoPersistence extends JpaRepository<Voto, Long> {

    List<Voto> findByEstudiante_Curso_Nombre(String curso);

    List<Voto> findByEstudiante_Curso_Mesa_NumMesa(Long numMesa);

    List<Voto> findByPartido_Candidato(String candidato);

}
