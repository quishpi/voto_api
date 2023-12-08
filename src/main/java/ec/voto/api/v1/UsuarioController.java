package ec.voto.api.v1;

import java.util.List;

import ec.voto.api.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.UsuarioDTO;
import ec.voto.api.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/user" })
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo() {
        List<UsuarioDTO> list = service.findAll(new UsuarioDTO());
        ApiResponseDTO<List<UsuarioDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<Object>(response, HttpStatus.OK));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody UsuarioDTO UsuarioDTO) {
        UsuarioDTO UsuarioDTOResult = service.save(UsuarioDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, UsuarioDTOResult), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody UsuarioDTO UsuarioDTO) {
        UsuarioDTO resultDTO = service.update(UsuarioDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "username/{username}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorUsername(@Valid @PathVariable("username") String username) {
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorUsername(username)), HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") String id) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(id);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
    }

    @GetMapping(value = "/admin", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarUsuariosAdmin() {
        List<UsuarioDTO> usuarioAdmin = service.buscarRolName("Admin");
        ApiResponseDTO<List<UsuarioDTO>> response = new ApiResponseDTO<>(true, usuarioAdmin);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/current-user", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarUsuariosCurrentUser() {
        List<UsuarioDTO> usuarioAdmin = service.buscarRolName("Current User");
        ApiResponseDTO<List<UsuarioDTO>> response = new ApiResponseDTO<>(true, usuarioAdmin);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody UsuarioDTO UsuarioDTO) {
        UsuarioDTO resultDTO = service.delete(UsuarioDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

}
