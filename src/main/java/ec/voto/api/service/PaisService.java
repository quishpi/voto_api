package ec.voto.api.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ec.voto.api.common.ApiException;
import ec.voto.api.domain.Pais;
import ec.voto.api.dto.PaisDTO;
import ec.voto.api.repository.PaisPersistence;

@Service
public class PaisService extends GenericCrudServiceImpl<Pais, PaisDTO> {

	@Autowired
	private PaisPersistence repository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public PaisDTO save(PaisDTO dto) {
		Optional<Pais> optional = find(dto);
		if (optional.isPresent()) {
			throw new ApiException(String.format("Usuario ya registrado en el sistema", dto));
		} else {
			dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

			return mapToDto(repository.save(mapToDomain(dto)));
		}
	}

	@Override
	public Optional<Pais> find(PaisDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Pais mapToDomain(PaisDTO dto) {
		return modelMapper.map(dto, Pais.class);
	}

	@Override
	public PaisDTO mapToDto(Pais domain) {
		return modelMapper.map(domain, PaisDTO.class);
	}

	public Optional<Pais> buscarPorCodigo(String codigo) {
		Optional<Pais> entidad = repository.findByCodigo(codigo);
		return entidad;
	}

}
