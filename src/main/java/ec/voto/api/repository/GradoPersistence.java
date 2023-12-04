package ec.voto.api.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Grado;

public interface GradoPersistence extends JpaRepository<Grado, Long> {

}
