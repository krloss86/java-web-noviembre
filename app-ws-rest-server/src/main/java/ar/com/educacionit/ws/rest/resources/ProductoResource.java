package ar.com.educacionit.ws.rest.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
public class ProductoResource {

	private ProductoService ps = new ProductoServiceImpl();
	
	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProductos() {
		try {
			List<Producto> productos = ps.findProductos();
			return Response.ok(productos).build();
		} catch (ServiceException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getProducto(@PathParam("id") Long id) {
		try {
			Producto producto = this.ps.getProductoById(id);
			
			if(producto != null) {
				return Response.ok(producto).build();				
			}else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} catch (ServiceException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearProducto(Producto producto) {
		
		//validaciones
		if(producto.getPrecio() == null) {
			//tarea!!!
			Map<String, String> errores = new HashMap<String, String>();
			errores.put("precio","Debe indicar el precio");
			return Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		// completan las que falan!
		
		try {			
			Producto productoCreado = this.ps.crearProducto(producto);
			return Response.status(Status.CREATED).entity(productoCreado).build();
		} catch (ServiceException e) {
			return construirErrores(e);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarProducto(Producto producto) {
		
		try {
			Producto productoActualizado = this.ps.updateProducto(producto);
			return Response.ok(productoActualizado).build();
		} catch (ServiceException e) {
			return construirErrores(e);
		}
	}
	
	@RolesAllowed({"ADMIN"})
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{codigo}")
	public Response deleteProducto(@PathParam("codigo") String codigo) {
		try {
			Producto productoEliminado = this.ps.eliminarProducto(codigo);
			return Response.ok(productoEliminado).build();
		} catch (ServiceException e) {
			//alt+shift+m
			return construirErrores(e);
		}
	}

	private Response construirErrores(ServiceException e) {
		Map<String, String> errores = new HashMap<String, String>();
		errores.put("error",e.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errores)
				.build();
	}
}
