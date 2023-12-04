package ec.voto.api.v1;

import java.util.List;

import ec.voto.api.dto.PartidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.VotoDTO;
import ec.voto.api.service.VotoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/v2.0/voto" })
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
        VotoDTO PaisDTOResult = service.save(VotoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, PaisDTOResult), HttpStatus.CREATED);
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

}
