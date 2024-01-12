package ec.voto.api.service;

import java.util.List;
import java.util.Optional;

import ec.voto.api.domain.Curso;
import ec.voto.api.domain.Partido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.voto.api.domain.Voto;
import ec.voto.api.dto.VotoDTO;
import ec.voto.api.repository.VotoPersistence;

@Service
public class VotoService extends GenericCrudServiceImpl<Voto, VotoDTO> {

    @Autowired
    private VotoPersistence repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Voto> find(VotoDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public Voto mapToDomain(VotoDTO dto) {
        return modelMapper.map(dto, Voto.class);
    }

    @Override
    public VotoDTO mapToDto(Voto domain) {
        return modelMapper.map(domain, VotoDTO.class);
    }

    public List<Voto> buscarPorCurso(String curso) {
        List<Voto> entidad = repository.findByEstudiante_Curso_Nombre(curso);
        return entidad;
    }

    public List<Voto> buscarNumMesa(Long numMesa) {
        List<Voto> entidad = repository.findByEstudiante_Curso_Mesa_NumMesa(numMesa);
        return entidad;
    }

    public List<Voto> buscarCandidato(String candidato) {
        List<Voto> entidad = repository.findByPartido_Candidato(candidato);
        return entidad;
    }

}
