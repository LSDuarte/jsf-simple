-- cria base de dados
create database livraria

-- usa base de dados
use livraria

-- cria tabelas
 create table Autor (
   id int identity not null,
   nome varchar(255),
   primary key (id)
 )

 create table Livro (
   id int identity not null,
   dataLancamento varchar(255),
   isbn varchar(255),
   preco double precision,
   titulo varchar(255),
   primary key (id)
 )
 create table Livro_Autor (
   Livro_id int not null,
   autores_id int not null
 )
 
 alter table Livro_Autor 
   add constraint FKm8wd9po92cbxh5rsa9c22ben 
   foreign key (autores_id) 
   references Autor

 alter table Livro_Autor 
   add constraint FKkg7c8c8lgwq3mkospcmupp706 
   foreign key (Livro_id) 
   references Livro


-- insere autores
insert into Autor (nome) 
	values ('Machado de Assis'),('Jorge Amado'),('Paulo Coelho'),('Cecilia Meireles'),('Clarice Lispector'),('Jose de Alencar'),
		   ('Mario de Andrade'),('Olavo Bilac')

select * from Autor
delete from Autor

-- insere livros 
insert into Livro (dataLancamento,isbn,preco,titulo)
	values ('18/05/1970','8506022428',24.90,'Dom Casmurro'),('21/07/2001','8500005920',30.00,'Contos Consagrados'),
		   ('22/01/2015','9788582055113',45.00,'O Sonho'),('15/04/2020','978-65-990504-2-8',99.00,'O Riso'),
		   ('04/10/1999','8520910173 ',15.45,'CRONICAS DE VIAGEM'),('15/04/2020','9788532531094 ',25.30,'Correio para mulheres'),
		   ('18/06/2000','8531902630  ',12.45,'NAMOROS COM A MEDICINA'),('15/04/2020','9788535917260',28.30,'Cacau')

select * from Livro
delete from Livro


select * from Livro_Autor