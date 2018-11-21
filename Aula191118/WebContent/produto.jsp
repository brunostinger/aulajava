<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Novo Produto</title>
<link  type="text/css" rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<div class="col-sm-11">
		<div class="panel panel-primary">
			<div class="panel-heading">Cadastrar / Editar</div>
			<div class="panel-body">


				<form method="post" action="ControleProduto">
					<div class="row">
						<fieldset>

							<div class="form-group">
								<label >Código produto</label>
								<input type="text" class="form-control" readonly='readonly' name="codigoproduto" id="codigoproduto" value="${produto.idProduto}">
							</div>


							<div class="form-group">
								<label >Nome</label>
								<input type="text" class="form-control" name="nome" id="nome" value="${produto.nome}" required>
							</div>


							<div class="form-group">
								<label >Descrição</label>
								<input type="text" class="form-control" name="descricao" id="descricao" value="${produto.descricao}" required>
							</div>
							
									
							<div class="form-group">
								<label >Valor</label>
								<input type="text" class="form-control" name="valor" id="valor" value="${produto.valor}" required>
							</div>														

							<div class="form-group">
								<label >Quantidade</label>
								<input type="text" class="form-control" name="quantidade" id="quantidade" value="${produto.quantidade}" required>
							</div>		
							
							
							<div class="form-group">
								<label >Unidade</label>
								<input type="text" class="form-control" name="unidade" id="unidade" value="${produto.unidade}" required>
							</div>	
							
						</fieldset>
					</div>
				 	<input type="submit" name="salvar" class="btn btn-primary">	
			  </form>
			  			
			</div>
		</div>
	</div>
</body>
</html>