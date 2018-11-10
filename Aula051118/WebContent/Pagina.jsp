<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

	<script type="text/javascript">
	function validarFormulario(titulo,login){
		var livros=["Livro 1","Livro 2","Livro 3","Livro 4","Livro 5","Livro 6"]
		var filmes=["Filme 1","Filme 2","Filme 3","Filme 4","Filme 5","Filme 6"];

		if(titulo.value=="livros"){
			alert(livros);
		}else if (titulo.value=="filmes"){
			alert(filmes);
		}else{
			alert(titulo.value+"----"+login.value)
		}

	}	
	
	
	function enviar(nome,profissao) {
			
		  var url="TesteServlet?nome="+nome.value+"&profissao="+profissao.value
		  console.log(url)
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("resultado").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET",url, true);
		  xhttp.send();
		}

	</script>
<link  type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<title>TESTE 7</title>
</head>
<body>
	<div class="col-sm-11">
		<div class="panel panel-primary">
			<div class="panel-heading">Cadastro</div>
			<div class="panel-body">


				<form method="get" onsubmit="enviar(nome,profissao); return false;">
					<div class="row">
						<fieldset>

							<div class="form-group">
								<label for="nome">Nome</label>
								<input type="text" class="form-control" name="nome" id="nome" autofocus required>
							</div>


							<div class="form-group">
								<label for="login">Profissão</label>
								<input type="text" class="form-control" name="profissao" id="profissao"  required>
							</div>


						</fieldset>
					</div>
				 	<input type="submit" name="salvar" class="btn btn-primary">	
			  </form>
			  
			  <div id="resultado"></div>
			
			</div>
		</div>
	</div>
</body>
</html>