package entidades;

public class Productos {
	private int id;
	private String codigo;
	private String descripcion;
	private double precioCosto;
	private double precioVenta;
	private double descuento;
	private double stock;
	private String unidadMedida;
	private String grupo;
	private boolean estado;
	private Marcas marca;

	public Productos() {
		id = 0;
		codigo = "";
		descripcion = "";
		precioCosto = 0;
		precioVenta = 0;
		descuento = 0;
		stock = 0;
		unidadMedida = "";
		grupo = "";
		estado = true;
		marca = new Marcas();
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCosto() {
		return precioCosto;
	}

	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
