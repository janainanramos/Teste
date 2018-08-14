package br.com.loja.controller.cliente;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loja.entity.Cliente;
import br.com.loja.util.JPAUtil;

@WebServlet("/cadastrarCliente")
public class CadastroCliente extends HttpServlet {
	
	private static final long serialVersionUID = -5706825700190386389L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cli = new Cliente();
		cli.setNome(request.getParameter("nome"));
		cli.setEndereco(request.getParameter("endereco"));
		cli.setBairro(request.getParameter("bairro"));
		cli.setCidade(request.getParameter("cidade"));
		cli.setTelefone(request.getParameter("telefone"));
		cli.setEmail(request.getParameter("email"));
		
				
		// para inserir
		
		JPAUtil jpa = new JPAUtil();
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();
		em.close();
	    
		
	    	    
	}

}
