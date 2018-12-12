package web.com.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import web.com.dao.ProdutoDAO;
import web.com.modelo.Produto;

@ViewScoped
@ManagedBean
public class ProdutoMB {

	Produto produto = new Produto();
	ProdutoDAO produtoDAO = new ProdutoDAO();
	private List<Produto> listaProduto = new ArrayList<>();

	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String idProduto = facesContext.getExternalContext().getRequestParameterMap().get("id");
		if(idProduto!=null) {
			this.produto=produtoDAO.consultarProdutoPorID(Integer.parseInt(idProduto));
		}
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public List<Produto> getListaProduto() {
		return produtoDAO.listarProdutos();
	}

	public String incluirprodutoDb(Produto produto) {
		if(!produtoDAO.inserirProduto(produto)) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao inserir produto",null));
			facesContext.getExternalContext().getFlash().setKeepMessages(true);
			
			return "/restrito/novoProduto?faces-redirect=true";
		}
		return "/restrito/listaProdutos?faces-redirect=true";
	}
	
	public String paginaEditar(Produto produto) {
		return"/restrito/editarProduto?faces-redirect=true&id="+produto.getId();
	}
	
	public String editarProduto(Produto produto) {
		produtoDAO.editarProduto(produto);
		return "/restrito/listaProdutos?faces-redirect=true";
	}
	
	public void deletarProduto(Produto produto) {
		produtoDAO.deletarProduto(produto);		
	}
}
