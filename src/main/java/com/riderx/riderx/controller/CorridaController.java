package com.riderx.riderx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.riderx.riderx.model.Corrida;
import com.riderx.riderx.repository.CorridaRepository;
import com.riderx.riderx.repository.VeiculoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/corridas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorridaController {

	@Autowired
	private CorridaRepository corridaRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Corrida>> getAll() {
		return ResponseEntity.ok(corridaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Corrida> getById(@PathVariable Long id) {
		return corridaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/destino/{destino}")
	public ResponseEntity<List<Corrida>> getByTitulo(@PathVariable String destino) {
		return ResponseEntity.ok(corridaRepository.findAllByDestinoContainingIgnoreCase(destino));

	}

	@PostMapping
	public ResponseEntity<Corrida> post(@Valid @RequestBody Corrida corrida) {
		if (veiculoRepository.existsById(corrida.getVeiculo().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).body(corridaRepository.save(corrida));

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Veiculo não existe!", null);
	}

	@PutMapping
	public ResponseEntity<Corrida> put(@Valid @RequestBody Corrida corrida) {
		if (corridaRepository.existsById(corrida.getId())) {

			if (veiculoRepository.existsById(corrida.getVeiculo().getId()))
				return ResponseEntity.status(HttpStatus.OK).body(corridaRepository.save(corrida));

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O veiculo não foi encontrado!", null);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Corrida> corrida = corridaRepository.findById(id);

		if (corrida.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		corridaRepository.deleteById(id);
	}
}
