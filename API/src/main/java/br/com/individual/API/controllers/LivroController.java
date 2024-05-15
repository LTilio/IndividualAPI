package br.com.individual.API.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.individual.API.model.Livro;
import br.com.individual.API.repository.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livroOpt = livroRepository.findById(id);
		if (!livroOpt.isEmpty()) {
			return ResponseEntity.ok(livroOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/att/{id}")
	public ResponseEntity<Livro> attLivro(@PathVariable Long id, @Valid @RequestBody Livro livro) {
		if (livroRepository.existsById(id)) {
			livro.setId(id);
			livro = livroRepository.save(livro);
			return ResponseEntity.ok(livro);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Livro addLivro(@Valid @RequestBody Livro livro) {	
		return livroRepository.save(livro);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> delLivro(@PathVariable Long id) {
		if (livroRepository.existsById(id)) {
			livroRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	// LEMBRAR DE TESTAR
	@GetMapping("/autor")
	public ResponseEntity<List<Livro>> livroPorAutor(@RequestParam String autor) {
		List<Livro> livros = livroRepository.findByInfoPublicacao_Autor(autor);
		if (!livros.isEmpty()) {
			return ResponseEntity.ok(livros);
		}
		return ResponseEntity.notFound().build();
	}
}
