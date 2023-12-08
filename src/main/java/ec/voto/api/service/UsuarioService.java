package ec.voto.api.service;

import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ec.voto.api.common.ApiException;
import ec.voto.api.domain.Usuario;
import ec.voto.api.dto.UsuarioDTO;
import ec.voto.api.repository.UsuarioPersistence;

@Service
public class UsuarioService extends GenericCrudServiceImpl<Usuario, UsuarioDTO>{

    @Autowired
    private UsuarioPersistence repository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        Optional<Usuario> optional = find(dto);
        if (optional.isPresent()) {
            throw new ApiException(String.format("Usuario ya registrado en el sistema: ", dto));
        } else {
            dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

            return mapToDto(repository.save(mapToDomain(dto)));
        }
    }

    @Override
    public Optional<Usuario> find(UsuarioDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public Usuario mapToDomain(UsuarioDTO dto) {
        return modelMapper.map(dto, Usuario.class);
    }

    @Override
    public UsuarioDTO mapToDto(Usuario domain) {
        return modelMapper.map(domain, UsuarioDTO.class);
    }

    public Optional<Usuario> buscarPorUsername(String username) {
        Optional<Usuario> entidad = repository.findByUsername(username);
        return entidad;
    }

    public List<UsuarioDTO> buscarRolName(String rolName) {
        List<Usuario> entidad = repository.findByRolName(rolName);
        return entidad.stream().map(this::mapToDto).collect(Collectors.toList());
    }

}
