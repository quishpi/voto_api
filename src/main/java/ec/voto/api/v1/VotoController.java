package ec.voto.api.v1;

import java.util.List;
import java.util.Objects;

import ec.voto.api.domain.Curso;
import ec.voto.api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.domain.Voto;
import ec.voto.api.service.VotoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/voto" })
public class VotoController {

    @Autowired
    VotoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listar() {
        List<VotoDTO> list = service.findAll(new VotoDTO());
        ApiResponseDTO<List<VotoDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<Object>(response, HttpStatus.OK));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody VotoDTO VotoDTO) {
        //change status of firmaAsistencia
        EstudianteDTO dto = VotoDTO.getEstudiante();
        dto.setFirmaAsistencia(true);
        //save Voto
        VotoDTO VotoDTOResult = service.save(VotoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, VotoDTOResult), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody VotoDTO VotoDTO) {
        VotoDTO resultDTO = service.update(VotoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody VotoDTO VotoDTO) {
        VotoDTO resultDTO = service.delete(VotoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.OK);
    }

    //know the votes for Grade
    @GetMapping(value = "curso/{curso}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorCurso(@Valid @PathVariable("curso") String curso) {
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorCurso(curso)), HttpStatus.OK);
    }

    //know the votes for tables
    @GetMapping(value = "mesa/{numMesa}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorCurso(@Valid @PathVariable("numMesa") Long numMesa) {
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarNumMesa(numMesa)), HttpStatus.OK);
    }

}
