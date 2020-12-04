package ar.com.educacionit.enums;

public enum ProductoClavesEnums {

	PRODUCTOS("productos"),
	LISTADO("listado"), 
	PRODUCTO("producto"), 
	TIPOS_PRODUCTOS("tiposProductos");
	
	private String clave;
	
	private ProductoClavesEnums(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}
}
