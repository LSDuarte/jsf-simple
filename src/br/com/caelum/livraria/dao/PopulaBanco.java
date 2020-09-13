package br.com.caelum.livraria.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

public class PopulaBanco {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Autor assis = geraAutor("Machado de Assis");
		em.persist(assis);
		
		Autor amado = geraAutor("Jorge Amado");
		em.persist(amado);
		
		Autor coelho = geraAutor("Paulo Coelho");
		em.persist(coelho);
		
		Livro casmurro = geraLivro("978-8-52-504464-8", "Dom Casmurro","10/01/1899",24.90,assis);
		Livro memorias = geraLivro("978-8-50-815415-9", "Mem�rias P�stumas de Br�s Cubas","01/01/1881",19.90,amado);
		Livro quincas = geraLivro("978-8-50-804084-1", "Quincas Borda","01/01/1891",16.90,assis);
		
		em.persist(casmurro);
		em.persist(memorias);
		em.persist(quincas);
		

		Livro alquemista = geraLivro("978-8-52-542758-3", "O Alquimista","10/01/1988",19.90,coelho);
		Livro brida = geraLivro("978-8-50-567258-7", "Brida","01/01/1990",12.90,coelho);
		Livro valkirias = geraLivro("978-8-52-812458-8", "As Valkirias","01/01/1992",29.90,coelho);
		Livro maao = geraLivro("978-8-51-892238-9", "O Di�rio de um Mago","01/01/1887",9.90,coelho);
		
		em.persist(alquemista);
		em.persist(brida);
		em.persist(valkirias);
		em.persist(maao);
		
		Livro capitaes = geraLivro("978-8-52-831169-1", "Capit�es da Areia","01/01/1937",6.90,amado);
		Livro flor = geraLivro("978-8-53-592569-9", "Dona Flor e Seus Dois Maridos","01/01/1966",18.00,amado);
		
		em.persist(capitaes);
		em.persist(flor);
		
		em.close();
		
	}

	private static Livro geraLivro(String isbn, String titulo, String data, double preco, Autor autor) {
		Livro livro = new Livro();
		livro.setIsbn(isbn);
		livro.setTitulo(titulo);
		livro.setPreco(preco);
		livro.setDataLancamento(parseData(data));
		return livro;
	}

	private static Autor geraAutor(String nome) {
		Autor autor = new Autor();
		autor.setNome(nome);
		return autor;
	}

	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}