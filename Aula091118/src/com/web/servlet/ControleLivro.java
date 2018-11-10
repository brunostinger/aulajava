package com.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import com.web.model.Livro;

/**
 * Servlet implementation class ControleLivro
 */
@WebServlet("/ControleLivro")
public class ControleLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ControleLivro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Livro> listaLivro = new ArrayList<>();

		for(int i = 1; i< 15 ; i++) {
			
			Livro livro = new Livro();
			livro.setAutor("Autor "+i);
			livro.setDescricao("Descricao "+i);
			livro.setTitulo("Titulo "+i);
			
			listaLivro.add(livro);
		}
		
		request.setAttribute("listaLivro", listaLivro);	

		HttpSession session = request.getSession();
		session.setAttribute("usuario","BRUNO");
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaLivro.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
