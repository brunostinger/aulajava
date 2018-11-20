package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivroDao;
import model.Livro;

/**
 * Servlet implementation class ControleLivro
 */
@WebServlet("/ControleLivro")
public class ControleLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleLivro() {
        super();
    }
    
    private static final String INSERIR_OU_EDITAR="/livro.jsp";
    private static final String LISTAR_LIVROS="/listaLivro.jsp";

	LivroDao livroDao = new LivroDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String pagina="";
		String titulo = request.getParameter("titulo");;
			
		if(acao.equals("deletar")) {						
			pagina=LISTAR_LIVROS;
			livroDao.deletarLivro(Integer.parseInt(request.getParameter("idLivro")));
			request.setAttribute("livros", livroDao.listarTodos());
		}
		 else if(acao.equals("editar")) {						
			 pagina=INSERIR_OU_EDITAR;
			 Livro livro = new Livro();
			 livro= livroDao.consultar(Integer.parseInt(request.getParameter("idLivro")));
			 request.setAttribute("livro", livro);
		}
		 else if(acao.equals("listarTodos")){
			 pagina=LISTAR_LIVROS;
			 request.setAttribute("livros", livroDao.listarTodos());
		}
		 else if(acao.equals("buscarLivros")){
			 pagina=LISTAR_LIVROS;
			 request.setAttribute("livros", livroDao.consultar(titulo));
		}else {
			 pagina=INSERIR_OU_EDITAR;
		}
					
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Livro livro = new Livro();
		livro.setTitulo(request.getParameter("titulo"));
		livro.setAutor(request.getParameter("autor"));
		livro.setDescricao(request.getParameter("descricao"));
		livro.setPreco( request.getParameter("preco") == null ? 0 : Double.parseDouble(request.getParameter("preco")));
		String codigoLivro = request.getParameter("codigoLivro");
		
		
		if(codigoLivro==null || codigoLivro.isEmpty()) {
			livroDao.inserir(livro);
		}else {
			livro.setCodigo(Integer.parseInt(codigoLivro));
			livroDao.updateTitulo(livro);
		}
		
		 request.setAttribute("livros", livroDao.listarTodos());

		RequestDispatcher rd = request.getRequestDispatcher(LISTAR_LIVROS);
		rd.forward(request, response);	
	}

}
