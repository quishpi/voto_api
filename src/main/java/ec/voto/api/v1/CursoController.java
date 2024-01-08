package ec.voto.api.v1;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.CursoDTO;
import ec.voto.api.service.CursoService;

@RestController
@RequestMapping(value = { "/api/v2.0/grado" })
public class CursoController {

    @Autowired
    CursoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo() {
        List<CursoDTO> list = service.findAll(new CursoDTO());
        ApiResponseDTO<List<CursoDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<Object>(response, HttpStatus.OK));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody CursoDTO CursoDTO) {
        CursoDTO cursoDTOResult = service.save(CursoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, cursoDTOResult), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody CursoDTO CursoDTO) {
        CursoDTO resultDTO = service.update(CursoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody CursoDTO CursoDTO) {
        CursoDTO resultDTO = service.delete(CursoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

}
