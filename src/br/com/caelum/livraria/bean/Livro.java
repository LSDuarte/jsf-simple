package br.com.caelum.livraria.bean;

public class Livro {
	
	public String titulo;
	public String isbn;
	public double preco;
	public String dataLancamento;

	public Livro() {
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