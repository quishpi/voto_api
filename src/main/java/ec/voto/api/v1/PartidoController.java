package ec.voto.api.v1;

import java.util.List;
import java.util.Optional;

import ec.voto.api.domain.Partido;
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
import ec.voto.api.dto.PartidoDTO;
import ec.voto.api.service.PartidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/v2.0/partido" })
public class PartidoController {

    @Autowired
    PartidoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo() {
        List<PartidoDTO> list = service.findAll(new PartidoDTO());
        ApiResponseDTO<List<PartidoDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<Object>(response, HttpStatus.OK));
    }

    /* Create a new candidate */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody PartidoDTO PartidoDTO) {
        PartidoDTO PartidoDTOResult = service.save(PartidoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, PartidoDTOResult), HttpStatus.CREATED);
    }

    /* Update info of candidates */
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody PartidoDTO PartidoDTO) {
        PartidoDTO resultDTO = service.update(PartidoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}/id", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
        PartidoDTO dto = new PartidoDTO();
        dto.setId(id);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
    }

    /* Find Partido with names of candidates */
    @GetMapping(value = "{numPartido}/numeroPartido", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorNumPartido(@Valid @PathVariable("numPartido") Long numPartido) {
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorNumPartido(numPartido)), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody PartidoDTO PartidoDTO) {
        PartidoDTO resultDTO = service.delete(PartidoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.OK);
    }
}
