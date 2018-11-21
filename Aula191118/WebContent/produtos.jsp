<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
<link  type="text/css" rel="stylesheet" href="css/bootstrap.css">

</head>
<body>
<div class="col-sm-11">

<p>
<div>
<form class="form-inline" method="get" action="ControleProduto?">
	<input type="text" name="filtroAplicar" class="form-control" id="filtroAplicar">
	<input type="submit" value="Buscar" class="btn btn-default">
	<input type="hidden" name="acao" id="acao" value="filtrarProdutos">
</form>
</div>
<p>


<table class="table table-bordered table-striped">
<thead class="">
	<tr>		
		<th><label>Código</label></th>
		
		<th><label>Nome</label></th>
		
		<th><label>Descricão</label></th>
			
		<th><label>Valor</label></th>
		
		<th><label>Qtd</label></th>
		
		<th><label>Un</label></th>
			
		<th colspan='2'><label>Acão</label></th>
			
	</tr>
</thead>

 <tbody>
 <c:forEach items="${produtos}" var="produto">
  	<tr>
  	  		<td><c:out value="${produto.idProduto}"></c:out></td>
  			<td><c:out value="${produto.nome}"></c:out></td>
  			<td><c:out value="${produto.descricao}"></c:out></td> 			
  			<td><c:out value="${produto.valor}"></c:out></td>  	
  			<td><c:out value="${produto.quantidade}"></c:out></td> 
  			<td><c:out value="${produto.unidade}"></c:out></td>  	
  			 	
  			<td><a href="ControleProduto?acao=editar&idproduto=${produto.idProduto}">Update</a></td>
  			<td><a href="ControleProduto?acao=deletar&idproduto=${produto.idProduto}">Deletar</a></td>  			
	</tr>
 </c:forEach>
 </tbody>
</table>
<a href="ControleProduto?acao=inserir"><input type="button" class="btn btn-primary" value='Novo'></a>


</div>
</body>
</html>