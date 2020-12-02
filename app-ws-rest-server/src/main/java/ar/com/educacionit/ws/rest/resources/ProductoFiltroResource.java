package ar.com.educacionit.ws.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

@Path("productos")
public class ProductoFiltroResource {

	private ProductoService productoService = new ProductoServiceImpl();
	
	/**
	 * Servicio que retorna un producto dado su descripcion
	 * 
	 * @param codigoProducto
	 * @return
	 */
	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("filtro/{descripcion}")
	public Response getByDescripcion(
			@PathParam("descripcion") String descripcion) throws Exception {

		try {
			// logica de negocio
			List<Producto> producto = productoService.findProductosByDescripcion(descripcion);

			if (producto == null) {
				producto = new ArrayList<>(); 
			}
			// jax-res -> json
			return Response.ok(producto).build();
		} catch (ServiceException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
