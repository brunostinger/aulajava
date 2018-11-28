package web.com.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.web.model.Livro;


@RequestScoped
@ManagedBean(name = "livroMB")
public class LivroMB {

	private Livro livro;
	private ArrayList<Livro> listaLivro;
	
	@PostConstruct
	public void init() {
		 System.out.println("**** Entrou metodo init ****");
		 	
		 listaLivro = new ArrayList<>();
		 
		 for(int i = 0; i< 10; i++) {
			 livro = new Livro(); 
			 livro.setCodigo(i);
			 livro.setTitulo("Titulo "+i);
			 livro.setAutor("Autor "+i);
			 livro.setPreco(i);
			 livro.setDescricao("Descricao "+i);
			 
			 listaLivro.add(livro);
		 }
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public ArrayList<Livro> getListaLivro() {
		return listaLivro;
	}

	public void setListaLivro(ArrayList<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}
	
	
}
