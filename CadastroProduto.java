package br.com.loja.controller.produto;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loja.entity.Cliente;
import br.com.loja.entity.Produto;
import br.com.loja.util.JPAUtil;

@WebServlet("/cadastrarProduto")
public class CadastroProduto extends HttpServlet {
	
	private static final long serialVersionUID = 6397348576394020367L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto pro = new Produto();
		pro.setNome(request.getParameter("nome"));
		pro.setPreco(request.getParameter("preco"));
		pro.setQuantidade(request.getParameter("quantidade"));
		
				
		// para inserir
		
		JPAUtil jpa = new JPAUtil();
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		em.persist(pro);
		em.getTransaction().commit();
		em.close();
		
		
	}

}
