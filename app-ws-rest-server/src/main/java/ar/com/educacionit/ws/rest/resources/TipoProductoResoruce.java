package ar.com.educacionit.ws.rest.resources;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

@Path("tipoproducto")
public class TipoProductoResoruce {

	private ProductoService productoService = new ProductoServiceImpl();
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		//ctrl+shit+o
		try {
			List<TipoProducto> productos = productoService.findTipoProductos();
			return Response.ok(productos).build();
		} catch (ServiceException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
