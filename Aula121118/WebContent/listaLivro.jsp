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
<table class="table">
<thead class="thead-dark">
	<tr>
		
		<th><label>Código</label></th>
		
		<th><label>Titulo</label></th>
		
		<th><label>Autor</label></th>
			
		<th><label>Descricao</label></th>
		
		<th><label>Preco</label></th>
		
		<th colspan='2'><label>Acão</label></th>
	
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
<p><a href="ControleLivro?acao=inserir"><input type="button" class="button" value='Novo'></a>
</body>
</html>