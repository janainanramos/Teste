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

@WebServlet("/removerCliente")
public class RemoveCliente extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		JPAUtil jpa = new JPAUtil();
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		Cliente cli = em.find(Cliente.class,1);
		em.remove(cli);
		em.getTransaction().commit();
		em.close();
		
		
		
	}	
	

}
