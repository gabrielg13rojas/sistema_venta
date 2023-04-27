package entidades;

import java.util.Date;

public class Cobranzas {
	private int id;
	private Date fecha;
	private double monto;
	private String notas;
	private Ventas venta;

	public Cobranzas() {
		id = 0;
		fecha = new Date();
		monto = 0;
		notas = "";
		venta= new Ventas();
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
}
