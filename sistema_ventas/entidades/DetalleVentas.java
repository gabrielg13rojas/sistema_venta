package entidades;

public class DetalleVentas {
	private int id;
	private double cantidad;
	private double precio;
	private double subtotal;
	private Ventas venta;
	private Productos producto;

	public DetalleVentas() {
		id = 0;
		cantidad = 0;
		precio = 0;
		subtotal = 0;
		venta = new Ventas();
		producto = new Productos();
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Ventas getVenta() {
		return venta;
	}

	public void setVenta(Ventas venta) {
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
