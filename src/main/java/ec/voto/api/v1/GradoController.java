package ec.voto.api.v1;
import java.util.List;

import ec.voto.api.dto.PartidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.GradoDTO;
import ec.voto.api.service.GradoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/v2.0/grado" })
public class GradoController {

    @Autowired
    GradoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo() {
        List<GradoDTO> list = service.findAll(new GradoDTO());
        ApiResponseDTO<List<GradoDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<Object>(response, HttpStatus.OK));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody GradoDTO GradoDTO) {
        GradoDTO GradoDTOResult = service.save(GradoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, GradoDTOResult), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody GradoDTO GradoDTO) {
        GradoDTO resultDTO = service.update(GradoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody GradoDTO GradoDTO) {
        GradoDTO resultDTO = service.delete(GradoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

}
