<%@page import="ar.com.educacionit.domain.Producto"%>
<%
	Producto productoCreadoEnElServlet = (Producto)request.getAttribute("productoCreado");
	out.print(productoCreadoEnElServlet.toString());
%>
