package ec.voto.api.v1;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.ProvinciaDTO;
import ec.voto.api.service.ProvinciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/v1.0/provincia" })
public class ProvinciaController {

	@Autowired
	private ProvinciaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<ProvinciaDTO> list = service.findAll(new ProvinciaDTO());
		ApiResponseDTO<List<ProvinciaDTO>> response = new ApiResponseDTO<>(true, list);
		return (new ResponseEntity<Object>(response, HttpStatus.OK));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody ProvinciaDTO ProvinciaDTO) {
		ProvinciaDTO ProvinciaDTOResult = service.save(ProvinciaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, ProvinciaDTOResult), HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody ProvinciaDTO ProvinciaDTO) {
		ProvinciaDTO resultDTO = service.update(ProvinciaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		ProvinciaDTO dto = new ProvinciaDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

}
 */
