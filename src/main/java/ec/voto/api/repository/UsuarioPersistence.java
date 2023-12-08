package ec.voto.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPersistence extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findById(String id);
    List<Usuario> findByRolName(String rolName);

}
