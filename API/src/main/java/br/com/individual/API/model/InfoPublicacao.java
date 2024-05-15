package br.com.individual.API.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Embeddable
public class InfoPublicacao {

	@NotBlank(message = "Peencha o titulo")
	@Size(max = 30, message = "Maximo de {max} letras")
	private String autor;
	
	@NotNull(message = "A data não pode ser nula")
	@Past(message = "A data deve estar no passado")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataPublicacao;
	
	@NotBlank(message = "Peencha o titulo")
	@Size(max = 30, message = "Maximo de {max} letras")
	private String editora;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
}
