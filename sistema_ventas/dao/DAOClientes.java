package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Clientes;
import utilidades.ConexionBD;

public class DAOClientes {
	public static void insertar(Clientes cli) {
		String sentencia = "INSERT INTO clientes(cli_cedula, cli_nombre, cli_apellido,"
				+ " cli_sexo, cli_telefono, cli_direccion, cli_nacimiento, cli_estado)" + " VALUES ('" + cli.getCedula()
				+ "', '" + cli.getNombre() + "', '" + cli.getApellido() + "', '" + cli.getSexo() + "', '"
				+ cli.getTelefono() + "','" + cli.getDireccion() + "', '" + cli.getNacimiento() + "', '"
				+ cli.isEstado() + "');";
		ConexionBD.conectar();
		System.out.println(sentencia);
		try {
			ConexionBD.stm.execute(sentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.desconectar();
	}

	public static void actualizar(Clientes cli) {
		String sentencia = "UPDATE clientes SET cli_cedula='" + cli.getCedula() + "', cli_nombre='" + cli.getNombre()
				+ "', cli_apellido='" + cli.getApellido() + "', cli_sexo='" + cli.getSexo() + "', cli_telefono='"
				+ cli.getTelefono() + "', cli_direccion='" + cli.getDireccion() + "', cli_nacimiento='"
				+ cli.getNacimiento() + "', cli_estado='" + cli.isEstado() + "' WHERE cli_id='" + cli.getId() + "';";
		System.out.println(sentencia);
		ConexionBD.conectar();
		try {
			ConexionBD.stm.execute(sentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.desconectar();
	}

	public static void eliminar(Clientes cli) {
		String sentencia = "DELETE FROM clientes WHERE cli_id=" + cli.getId();

		System.out.println(sentencia);
		ConexionBD.conectar();
		try {
			ConexionBD.stm.execute(sentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.desconectar();
	}

	public static ArrayList<Clientes> consultar(String filtro) {
		ArrayList<Clientes> lista = new ArrayList<>();
		String sentencia = "SELECT * FROM clientes WHERE cli_cedula ILIKE '%"+filtro+"%' OR cli_nombre ILIKE '%"+filtro+"%' OR cli_apellido ILIKE '%"+filtro+"%'";
		ConexionBD.conectar();
		try {
			ResultSet resultado = ConexionBD.stm.executeQuery(sentencia);
			Clientes cliente = null;
			while (resultado.next()) {
				cliente = new Clientes();
				cliente.setId(resultado.getInt("cli_id"));
				cliente.setCedula(resultado.getString("cli_cedula"));
				cliente.setNombre(resultado.getString("cli_nombre"));
				cliente.setApellido(resultado.getString("cli_apellido"));
				cliente.setDireccion(resultado.getString("cli_direccion"));
				cliente.setEstado(resultado.getBoolean("cli_estado"));
				cliente.setNacimiento(resultado.getDate("cli_nacimiento"));
				cliente.setSexo(resultado.getInt("cli_sexo"));
				cliente.setTelefono(resultado.getString("cli_telefono"));

				lista.add(cliente);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.desconectar();
		return lista;
	}
}
