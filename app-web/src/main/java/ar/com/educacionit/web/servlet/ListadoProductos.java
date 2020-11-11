package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.soap.server.Producto;
import ar.com.educacionit.soap.server.impl.ProductoWSSoapServiceImplService;
import ar.com.educacionit.soap.server.impl.ProductoWsSoapService;
import ar.com.educacionit.soap.server.impl.WSSoapException;

@WebServlet("/ListadoProductos")
public class ListadoProductos extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoWSSoapServiceImplService psws = new ProductoWSSoapServiceImplService();
		
		ProductoWsSoapService ps = psws.getProductoWSSoapServiceImplPort();
		
		try {
			//ctrl+shit+o
			List<Producto> productos = ps.listAll();
			
			request.setAttribute("productos", productos);
		} catch (WSSoapException e) {
			request.setAttribute("productos", new ArrayList<>());
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/productos.jsp") ;
		
		rd.forward(request, response);
	}
}
