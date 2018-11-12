<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Novo Livro</title>
<link  type="text/css" rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<div class="col-sm-11">
		<div class="panel panel-primary">
			<div class="panel-heading">Cadastro</div>
			<div class="panel-body">


				<form method="post" action="ControleLivro">
					<div class="row">
						<fieldset>

							<div class="form-group">
								<label for="nome">Código Livro</label>
								<input type="text" class="form-control" readonly='readonly' name="codigoLivro" id="codigoLivro" value="${livro.codigo}">
							</div>


							<div class="form-group">
								<label for="login">Título</label>
								<input type="text" class="form-control" name="titulo" id="titulo" value="${livro.titulo}" required>
							</div>


							<div class="form-group">
								<label for="login">Autor</label>
								<input type="text" class="form-control" name="autor" id="autor" value="${livro.autor}" required>
							</div>
							
							<div class="form-group">
								<label for="login">Descrição</label>
								<input type="text" class="form-control" name="descricao" id="descricao" value="${livro.descricao}">
							</div>
							
									
							<div class="form-group">
								<label for="login">Preço</label>
								<input type="text" class="form-control" name="preco" id="preco" value="${livro.preco}">
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