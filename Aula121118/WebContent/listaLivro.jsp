<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Livros</title>

<link  type="text/css" rel="stylesheet" href="css/bootstrap.css">

</head>
<body>
<p>
<div>
<form class="form-inline" method="get" action="ControleLivro?">
	<input type="text" name="titulo" class="form-control" id="titulo">
	<input type="submit" value="Buscar" class="btn btn-default">
	<input type="hidden" name="acao" id="acao" value="buscarLivros">
</form>
</div>
<p>
<table class="table table-bordered table-striped">
<thead class="">
	<tr>		
		<th><label>C�digo</label></th>
		
		<th><label>Titulo</label></th>
		
		<th><label>Autor</label></th>
			
		<th><label>Descricao</label></th>
		
		<th><label>Preco</label></th>
		
		<th colspan='2'><label>Ac�o</label></th>
	
	</tr>
</thead>

 <tbody>
 <c:forEach items="${livros}" var="livro">
  	<tr>
  	  		<td><c:out value="${livro.codigo}"></c:out></td>
  			<td><c:out value="${livro.titulo}"></c:out></td>
  			<td><c:out value="${livro.autor}"></c:out></td> 			
  			<td><c:out value="${livro.descricao}"></c:out></td>  	
  			<td><c:out value="${livro.preco}"></c:out></td>  	
  			<td><a href="ControleLivro?acao=editar&idLivro=${livro.codigo}">Update</a></td>
  			<td><a href="ControleLivro?acao=deletar&idLivro=${livro.codigo}">Deletar</a></td>  			
	</tr>
 </c:forEach>
 </tbody>
</table>


<a href="ControleLivro?acao=inserir"><input type="button" class="btn btn-primary" value='Novo'></a>
</body>
</html>