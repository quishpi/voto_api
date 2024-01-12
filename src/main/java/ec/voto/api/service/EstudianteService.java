package ec.voto.api.service;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.voto.api.domain.Estudiante;
import ec.voto.api.dto.EstudianteDTO;
import ec.voto.api.repository.EstudiantePersistence;

@Service
public class EstudianteService extends GenericCrudServiceImpl<Estudiante, EstudianteDTO> {

    @Autowired
    private EstudiantePersistence repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Estudiante> find(EstudianteDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public Estudiante mapToDomain(EstudianteDTO dto) {
        return modelMapper.map(dto, Estudiante.class);
    }

    @Override
    public EstudianteDTO mapToDto(Estudiante domain) {
        return modelMapper.map(domain, EstudianteDTO.class);
    }

    public List<Estudiante> buscarPorFirmaAsistencia(Boolean firmaAsistencia) {
        List<Estudiante> entidad = repository.findByFirmaAsistencia(firmaAsistencia);
        return entidad;
    }

}
