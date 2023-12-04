package ec.voto.api.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.voto.api.domain.Grado;
import ec.voto.api.dto.GradoDTO;
import ec.voto.api.repository.GradoPersistence;

@Service
public class GradoService extends GenericCrudServiceImpl<Grado, GradoDTO> {

    @Autowired
    private GradoPersistence repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Grado> find(GradoDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public Grado mapToDomain(GradoDTO dto) {
        return modelMapper.map(dto, Grado.class);
    }

    @Override
    public GradoDTO mapToDto(Grado domain) {
        return modelMapper.map(domain, GradoDTO.class);
    }

}
