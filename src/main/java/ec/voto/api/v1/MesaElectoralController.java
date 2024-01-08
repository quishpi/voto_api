package ec.voto.api.v1;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.MesaElectoralDTO;
import ec.voto.api.service.MesaElectoralService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/mesa" })
public class MesaElectoralController {
    @Autowired
    MesaElectoralService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo() {
        List<MesaElectoralDTO> list = service.findAll(new MesaElectoralDTO());
        ApiResponseDTO<List<MesaElectoralDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<Object>(response, HttpStatus.OK));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody MesaElectoralDTO MesaElectoralDTO) {
        MesaElectoralDTO PaisDTOResult = service.save(MesaElectoralDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, PaisDTOResult), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody MesaElectoralDTO MesaElectoralDTO) {
        MesaElectoralDTO resultDTO = service.update(MesaElectoralDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}/id", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
        MesaElectoralDTO dto = new MesaElectoralDTO();
        dto.setId(id);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody MesaElectoralDTO MesaElectoralDTO) {
        MesaElectoralDTO resultDTO = service.delete(MesaElectoralDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.OK);
    }

}
