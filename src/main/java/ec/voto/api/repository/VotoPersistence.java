package ec.voto.api.repository;
import java.util.List;
import java.util.Optional;

import ec.voto.api.domain.Curso;
import ec.voto.api.domain.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Voto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VotoPersistence extends JpaRepository<Voto, Long> {

    List<Voto> findByEstudiante_Curso_Nombre(String curso);

    List<Voto> findByEstudiante_Curso_Mesa_NumMesa(Long numMesa);

    //Count Partido and her votes
    @Query("SELECT v.partido.candidato, COUNT(v) FROM Voto v WHERE v.partido.candidato = :candidato GROUP BY v.partido.candidato")
    List<Object[]> countByPartidoCandidatoGroupBy(@Param("candidato") String candidato);

}
