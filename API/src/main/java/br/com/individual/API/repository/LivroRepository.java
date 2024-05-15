package br.com.individual.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.individual.API.model.Livro;
import java.util.List;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	List<Livro> findByInfoPublicacao_Autor(String autor);
	
}
