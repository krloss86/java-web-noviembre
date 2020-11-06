package ar.com.educacionit.soap.dto;

public class CreateProductoDTO {
	
	private String descripcion;
	
	private Float precio;
	
	private String codigo;
	
	private Long tipoProductoId;

	public CreateProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CreateProductoDTO(String descripcion, Float precio, String codigo, Long tipoProductoId) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProductoId = tipoProductoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getTipoProductoId() {
		return tipoProductoId;
	}

	public void setTipoProductoId(Long tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}
	
}
