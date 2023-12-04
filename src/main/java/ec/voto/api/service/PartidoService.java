package ec.voto.api.service;

import java.util.Optional;

import ec.voto.api.domain.Partido;
import ec.voto.api.dto.PartidoDTO;
import ec.voto.api.repository.PartidoPersistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PartidoService extends GenericCrudServiceImpl<Partido, PartidoDTO> {

    @Autowired
    private PartidoPersistence repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Partido> find(PartidoDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public Partido mapToDomain(PartidoDTO dto) {
        return modelMapper.map(dto, Partido.class);
    }

    @Override
    public PartidoDTO mapToDto(Partido domain) {
        return modelMapper.map(domain, PartidoDTO.class);
    }

    public Optional<Partido> buscarPorNumPartido(Long numPartido) {
        Optional<Partido> entidad = repository.findByNumPartido(numPartido);
        return entidad;
    }
}