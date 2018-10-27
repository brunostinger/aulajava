function dataAtual()
{
	document.getElementById('demo2').innerHTML=" Data função "+Date();
}

function alterarTamanhoFonte(){

	var tamanhoFonte=document.getElementById('demo').style.fontSize;
	console.log(tamanhoFonte);
	if(tamanhoFonte=="50px"){
		document.getElementById('demo').style.fontSize="30px";
		document.getElementById('demo2').style.fontSize="30px";
	}
	else{
		document.getElementById('demo').style.fontSize="50px";
		document.getElementById('demo2').style.fontSize="50px";
	}

}

function MostrarOcultar(){

	var atual = document.getElementById('demo').style.display;
	if(atual==""){
		document.getElementById('demo').style.display=  "none";
		document.getElementById('demo2').style.display=  "none";

	}
	else{

		document.getElementById('demo').style.display=  "";
		document.getElementById('demo2').style.display=  "";
	}
	console.log(atual);
}

function validarFormulario(){
	var nome=document.forms["form1"]["nome"].value;
	if(nome==""){
		alert("Infome o nome")
		return false;
	}
}
