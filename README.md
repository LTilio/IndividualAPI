<h1 align= center>API Restful</h1>

## 📝 Indicie
<ul>
  <li>Sobre o projeto</li>
  <li>Tecnologias utilizadas</li>
  <li>EndPoints</li>
  <li>Autor do projeto</li>
</ul>


## :desktop_computer: Sobre o projeto
<b>
Desenvolver um sistema de biblioteca e precisam criar uma entidade livro contendo as informações, id, titulo
O livro tambem deve ter informações da publicacao contendo autor, data da publicacao, e editora
(Livro, InformacaoPublicacao) (@Embedded, @Embeddable)
  
requisitos minimos;
<ul>
  <li>Entidade</li>
  <li>Interface do repositorio</li>
  <li>CRUD Basico</li>
  <li>Tratamento dos campos obrigatórios na classe Livro (titulo, autor)</li>
  <li>Tratamento das exceções</li>
  <li>Usar o banco H2</li>
</ul>
  
  ## :hammer_and_wrench: Tecnologias Utilizadas  

  Java 17

  ## :dart: EndPOoints

  FindAll - localhost:8080/livros

  FindById - localhost:8080/livros/1

  FindByAutor - localhost:8080/livros/autor?autor=Jan Gehl
  
  Put - localhost:8080/livros/att/1

  Pots - localhost:8080/livros/add

  Delete - localhost:8080/livros/del/1

 
  ## 👀 Autor do projeto

  Leandro Tilio - [LTilio](https://github.com/LTilio)
