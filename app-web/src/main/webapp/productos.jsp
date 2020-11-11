<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.soap.server.Producto"%>
<%
	List<Producto> productos = (List<Producto>)request.getAttribute("productos");
	for(Producto producto : productos) {
		out.println(producto.getId() + " - " + producto.getTitulo());
		out.println("<br>");
	}
%>
