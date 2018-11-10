<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link  type="text/css" rel="stylesheet" href="css/bootstrap.css">

</head>
<body>
<label>${sessionScope.usuario}</label>
<table class="table">
<thead class="thead-dark">
	<tr>
		<th><label>Autor</label></th>
		
		<th><label>Titulo</label></th>
		
		<th><label>Descricao</label></th>
		
	</tr>
</thead>

 <tbody>
 <c:forEach items="${requestScope.listaLivro}" var="livro">
  	<tr>
  	  		<td><c:out value="${livro.autor}"></c:out></td>
  			<td><c:out value="${livro.titulo}"></c:out></td>
  			<td><c:out value="${livro.descricao}"></c:out></td>  	
	</tr>
 </c:forEach>
 </tbody>
</table>

</body>
</html>