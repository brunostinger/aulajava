package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession(true);

		//recupera o atributo da sessao
		boolean logado = false;
		if(session.getAttribute("logado")!=null) {
			logado = (boolean) session.getAttribute("logado");
		}
		
		//se logado falso usuario nao iniciou sessao - nao esta logado
		if(!logado) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			
			//se logado redireciona para pagina
			((HttpServletResponse) response).sendRedirect(contextPath + "/login/loginUsuario.xhtml");
		}else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
