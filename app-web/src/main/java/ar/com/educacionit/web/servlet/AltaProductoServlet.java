package ar.com.educacionit.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

@WebServlet("/AltaProductoServlet")
public class AltaProductoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String codigo = request.getParameter("codigo");
		String precio = request.getParameter("precio");
		String tipoProducto = request.getParameter("tipoProducto");
		
		Float precioF = Float.parseFloat(precio);
		Long tipoProductoL = Long.parseLong(tipoProducto);
		
		Producto producto = new Producto(titulo,precioF,codigo,tipoProductoL);
		
		//llamar al servicio ProductoService
		ProductoService productoService = new ProductoServiceImpl();
		
		Producto nuevoProducto = productoService.crearProducto(producto);
		
		request.setAttribute("productoCreado", nuevoProducto);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/producto.jsp") ;
		
		rd.forward(request, response);
	}
}
