package ec.voto.api.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.voto.api.domain.MesaElectoral;
import ec.voto.api.dto.MesaElectoralDTO;
import ec.voto.api.repository.MesaElectoralPersistence;

@Service
public class MesaElectoralService extends GenericCrudServiceImpl<MesaElectoral, MesaElectoralDTO> {

    @Autowired
    private MesaElectoralPersistence repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<MesaElectoral> find(MesaElectoralDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public MesaElectoral mapToDomain(MesaElectoralDTO dto) {
        return modelMapper.map(dto, MesaElectoral.class);
    }

    @Override
    public MesaElectoralDTO mapToDto(MesaElectoral domain) {
        return modelMapper.map(domain, MesaElectoralDTO.class);
    }

}
