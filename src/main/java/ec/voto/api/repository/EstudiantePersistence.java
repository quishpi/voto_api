package ec.voto.api.repository;

import ec.voto.api.domain.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudiantePersistence extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByFirmaAsistencia(Boolean firmaAsistencia);

}
