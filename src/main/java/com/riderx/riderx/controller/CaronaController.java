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

import com.riderx.riderx.model.Carona;
import com.riderx.riderx.repository.CaronaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/caronas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class  CaronaController {

	@Autowired
	private CaronaRepository caronaRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Carona>> getAll() {
		return ResponseEntity.ok(caronaRepository.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Carona> getById(@PathVariable Long id) {
		return caronaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Carona> post(@Valid @RequestBody Carona carona){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(caronaRepository.save(carona));
	}
	
	@PutMapping
	public ResponseEntity<Carona> put(@Valid @RequestBody Carona carona){
		return caronaRepository.findById(carona.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(caronaRepository.save(carona)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Carona> carona = caronaRepository.findById(id);
		
		if(carona.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		caronaRepository.deleteById(id);
	}

}
