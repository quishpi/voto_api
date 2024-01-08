package ec.voto.api.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.MesaElectoral;
public interface MesaElectoralPersistence extends JpaRepository<MesaElectoral, Long>  {

}
