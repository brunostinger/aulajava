package web.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TesteServlet")
public class TesteServlet extends HttpServlet{
	
private static final long serialVersionuid=1L;

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	String nome=req.getParameter("nome");
	String profissao=req.getParameter("profissao");

	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	out.println("<html><head></head><body><h1>Meu nome é: "+nome+" e minha Profissão é "+profissao+"</h1></body></html>");
	
	}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}