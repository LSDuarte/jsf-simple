-- cria base de dados
create database livraria

-- usa base de dados
use livraria

-- cria tabelas
create table Autor (
	id int identity(1,1) primary key,
	nome varchar(100) null
)

create table Livro (
	id int identity(1,1) primary key,
	titulo varchar(100) null,
	isbn varchar(100) null,
	preco real null,
	dataLancamento varchar(100) null,

	autores int foreign key references Autor(id)
)


-- insere autores
insert into Autor (nome) 
	values ('Machado de Assis'),('Jorge Amado'),('Paulo Coelho'),('Cecilia Meireles'),('Clarice Lispector'),('Jose de Alencar'),
		   ('Mario de Andrade'),('Olavo Bilac')

select * from Autor


-- insere livros e vinculo de autores
insert into Livro (titulo,isbn,preco,dataLancamento, autores)
	values ('Dom Casmurro','8506022428',24.90,'18/05/1970',1),('Contos Consagrados','8500005920',30.00,'21/07/2001',1),
		   ('O Sonho','9788582055113',45.00,'22/01/2015',8),('O Riso','978-65-990504-2-8',99.00,'15/04/2020',8),
		   ('CRONICAS DE VIAGEM','8520910173 ',15.45,'04/10/1999',4),('Correio para mulheres','9788532531094 ',25.30,'15/04/2020',5),
		   ('NAMOROS COM A MEDICINA','8531902630  ',12.45,'18/06/2000',7),('Cacau','9788535917260',28.30,'15/04/2020',2)

select * from Livro