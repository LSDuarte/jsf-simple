package br.com.caelum.livraria.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "titulo")
	public String titulo;
	
	@Column(name = "isbn")
	public String isbn;
	
	@Column(name = "preco")
	public double preco;
	
	@Column(name = "dataLancamento")
	public String dataLancamento;

	
	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();

	public List<Autor> getAutores() {
		return autores;
	}

	// metodo que adiciona o autor
	public void adicionaAutor(Autor autor) {
		this.autores.add(autor); // est� usando this. para pegar a variavel autores do arraylist
	}

	public Livro() {
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getTitulo() {
		return titulo;
	}

	public final void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public final String getIsbn() {
		return isbn;
	}

	public final void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public final double getPreco() {
		return preco;
	}

	public final void setPreco(double preco) {
		this.preco = preco;
	}

	public final String getDataLancamento() {
		return dataLancamento;
	}

	public final void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
}