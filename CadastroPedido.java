package br.com.loja.controller.pedido;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loja.entity.Cliente;
import br.com.loja.entity.Pedido;
import br.com.loja.util.JPAUtil;

@WebServlet("/cadastrarPedido")
public class CadastroPedido extends HttpServlet {
	
	private static final long serialVersionUID = 5210671149982378288L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pedido ped = new Pedido();
		ped.setCliente(request.getParameter("nome"));
		ped.setProduto(request.getParameter("produto"));
		ped.setQuantidade(request.getParameter("quantidade"));
		ped.setCidade(request.getParameter("cidade"));
		ped.setPreco(request.getParameter("preco"));
		ped.setTotal(request.getParameter("total"));
		
				
				
		JPAUtil jpa = new JPAUtil();
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		em.persist(ped);
		em.getTransaction().commit();
		em.close();
		
	}

}
