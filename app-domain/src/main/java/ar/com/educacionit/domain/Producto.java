package ar.com.educacionit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;
	
	@Column(name = "precio", nullable = false)
	private Float precio;
	
	@Column(name = "codigo", nullable = false, length = 6)
	private String codigo;
	
	//alt+shit+s
	@ManyToOne
	@JoinColumn(name = "tipo_producto", referencedColumnName = "id")
	private TipoProducto tipoProducto;

	//contructor por defecto
	public Producto() {
		
	}
	
	public Producto(String titulo, Float precio, String codigo, Long tipo) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setId(tipo);
		this.tipoProducto = tipoProducto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	//get/set
	
}
