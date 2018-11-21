package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDao;
import modelo.Produto;

@WebServlet("/ControleProduto")
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControleProduto() {
        super();

    }

    private static final String LISTAR="/produtos.jsp";
    private static final String INSERIR_EDITAR="/produto.jsp";

	ProdutoDao produtoDao = new ProdutoDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String pagina="";
		String idProduto = request.getParameter("idproduto");
		String filtroAplicar = request.getParameter("filtroAplicar");

		
		
/*		if(acao==null) 
			//pagina erro
*/	
		
		if(acao.equals("listarProdutos")) {
			pagina=LISTAR;
			request.setAttribute("produtos", produtoDao.listarProdutos());	
		}
		else if (acao.equals("deletar")) {
			pagina=LISTAR;
			produtoDao.deletarProduto(Integer.parseInt(request.getParameter("idproduto")));
			request.setAttribute("produtos", produtoDao.listarProdutos());	
		}
		else if (acao.equals("editar")) {
			pagina=INSERIR_EDITAR;
			request.setAttribute("produto", produtoDao.buscarProduto(Integer.parseInt(idProduto)));	
		} else if (acao.equals("filtrarProdutos")) {
			pagina=LISTAR;
			request.setAttribute("produtos", produtoDao.filtrarProdutos(filtroAplicar));	
		}		
		else {
			pagina=INSERIR_EDITAR;
		}
	
		
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Produto produto = new Produto();
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setValor(Double.valueOf(request.getParameter("valor")));
		produto.setQuantidade(Double.valueOf(request.getParameter("quantidade")));
		produto.setUnidade(request.getParameter("unidade"));
		
		String idProduto = request.getParameter("codigoproduto");

		
		if(idProduto==null || idProduto.isEmpty()) {
			produtoDao.inserir(produto);
		}else {
			produto.setIdProduto(Integer.parseInt(idProduto));
			produtoDao.atualizarProduto(produto);
		}
		
		 request.setAttribute("produtos", produtoDao.listarProdutos());

		RequestDispatcher rd = request.getRequestDispatcher(LISTAR);
		rd.forward(request, response);	
		
		
		
	}

}
