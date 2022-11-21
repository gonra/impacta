package com.atos.impacta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atos.impacta.model.Gerente;
import com.atos.impacta.repositories.RepositorioGerente;

@WebServlet("/WebInicio")
public class WebInicio extends HttpServlet {


	RepositorioGerente repositorioGerente;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WebInicio() {
		super();
		repositorioGerente = new RepositorioGerente();
	}
	
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException,IOException{
		PrintWriter htmlOut = response.getWriter();
		response.setContentType("text/html");  
//		htmlOut.append("<html><body>")
//			.append("Hola Impacta")
//			.append("</body></html>");
		htmlOut.println("<!DOCTYPE html>");		
		htmlOut.println("<html>");
		
		htmlOut.println("<head>");
		htmlOut.println("<meta charset=\"utf-8\">");
		htmlOut.println("<title>Segunda parte</title>");
		htmlOut.println("</head>");
		htmlOut.println("<body>");
		htmlOut.println("<h3><i>Segunda parte impacta</i></h3>");
		htmlOut.println("<div><table border=\"1\" width=\"800\">");
		htmlOut.println("<tr><td colspan=\"2\" ALIGN=\"CENTER\"><H3>Ficha aluno</H3></td></tr>");
		htmlOut.println("<tr><td><b>NOME</b></td><td>GONZALO</td></tr>");
		htmlOut.println("<tr><td><b>IDADE</b></td><td>DESCONHECIDA</td></tr>");
		htmlOut.println("<tr><td><b>EMAIL</b></td><td>GONZALO.2.ALVAREZ @ ATOS.NET</td></tr>");
		htmlOut.println("<tr><td><b>TIME</b></td><td>STARK</td></tr>");
		htmlOut.println("<tr><td><b>COMO ME VEJO EM UNS ANOS MAIS NO JAVA</b></td><td>SENIOR++ ATUALIZANDO CONHECIMENTOS</td></tr>");
		htmlOut.println("</table></div>");
		htmlOut.println("</body>");
		htmlOut.println("</html>");
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String nome=request.getParameter("nome");  
        String cpf=request.getParameter("cpf");
        Double salario=Double.parseDouble(request.getParameter("salario"));
        String regional=request.getParameter("regional");
        Double metaregional=Double.parseDouble(request.getParameter("metaregional"));
        
        Gerente ger = repositorioGerente.listarGerenteByCpfDb(cpf);
        if(ger==null) {
        	Gerente gerente = new Gerente();
        	gerente.setNome(nome);
        	gerente.setCpf(cpf);
        	gerente.setSalario(salario);
        	gerente.setRegional(regional);
        	gerente.setMetaRegional(metaregional);
        	boolean valido = repositorioGerente.salvarGerenteDB(gerente);
        	request.setAttribute("gerente",gerente);  
        	RequestDispatcher rd=request.getRequestDispatcher("GerenteSalvado.jsp");  
        	rd.forward(request, response);
        } else {
        	request.setAttribute("gerente",ger);  
        	RequestDispatcher rd=request.getRequestDispatcher("GerenteExistente.jsp");
        	rd.forward(request, response);
        }
	}

}
