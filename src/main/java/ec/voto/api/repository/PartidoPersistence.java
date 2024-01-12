package ec.voto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Partido;

import java.util.Optional;

public interface PartidoPersistence extends JpaRepository<Partido, Long> {
    Optional<Partido> findByCandidato(String candidato);

    Optional<Partido> deletePartidoById(Long id);
}

