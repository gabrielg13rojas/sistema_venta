package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Ventas {
	private int id;
	private int condicion;
	private String numero;
	private Date fecha;
	private double total;
	private boolean estado;
	private boolean pagado;
	private Clientes cliente;
	private ArrayList<DetalleVentas> listaDetalle;

	public Ventas() {
		id = 0;
		condicion = 0;
		numero = "";
		fecha = new Date();
		total = 0d;
		estado = true;
		pagado = false;
		cliente = new Clientes();
		listaDetalle = new ArrayList<>();
	}
	
	
	
	public Clientes getCliente() {
		return cliente;
	}



	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}



	public ArrayList<DetalleVentas> getListaDetalle() {
		return listaDetalle;
	}



	public void setListaDetalle(ArrayList<DetalleVentas> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCondicion() {
		return condicion;
	}

	public void setCondicion(int condicion) {
		this.condicion = condicion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
}
