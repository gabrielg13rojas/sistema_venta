package formularios;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import componentes.TextField;
import componentes.TablaCustom;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import componentes.Combobox;
import componentes.TextArea;
import javax.swing.JFormattedTextField;
import componentes.TextFieldFormat;
import dao.DAOClientes;
import entidades.Clientes;
import report.Reporte;
import utilidades.ConexionBD;

import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormClientes extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private TextField tfBuscador;
	private TextField tfCedula;
	private TablaCustom tbClientes;
	private TextField tfNombre;
	private TextArea tfDireccion;
	private JScrollPane scrollPane;
	private TextFieldFormat tfFechaNacimiento;
	private JRadioButton rdbtnActivo;
	private TextField tfID;
	private TextField tfApellido;
	private Combobox cbxSexo;
	private TextField tfTelefono;
	private JRadioButton rdbtnInactivo;

	private ArrayList<Clientes> listaClientes = new ArrayList<>();

	public FormClientes() {
		setFrameIcon(new ImageIcon(FormClientes.class.getResource("/img/clientes.png")));
		setTitle("Registro de clientes");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
//		try {
//			setMaximum(true);
//		} catch (PropertyVetoException e1) {
//			e1.printStackTrace();
//		}
		setBounds(0, 0, 1024, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/nuevo.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoFormulario(true);
			}
		});
		btnNuevo.setBounds(10, 505, 129, 54);
		contentPanel.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/guardar.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setBounds(153, 505, 141, 54);
		contentPanel.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoFormulario(false);
			}
		});
		btnCancelar.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/cancelar.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnCancelar.setBounds(309, 505, 129, 54);
		contentPanel.add(btnCancelar);

		tfID = new TextField();
		tfID.setEnabled(false);
		tfID.setLabelText("ID");
		tfID.setBounds(10, 11, 183, 54);
		contentPanel.add(tfID);

		tfBuscador = new TextField();
		tfBuscador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					consultar();
				}
			}
		});
		tfBuscador.setLabelText("Buscar por cédula, nombre o apellido");
		tfBuscador.setBounds(448, 11, 412, 54);
		contentPanel.add(tfBuscador);

		tfCedula = new TextField();
		tfCedula.setLabelText("Cédula");
		tfCedula.setBounds(203, 11, 235, 54);
		contentPanel.add(tfCedula);

		tbClientes = new TablaCustom();
		tbClientes.setBounds(448, 76, 550, 483);
		tbClientes.setColumnas(new String[] { "ID", "CÉDULA", "NOMBRE Y APELLIDO", "SEXO", "TELÉFONO", "NACIMIENTO" },
				accionEliminar, accionEditar, tfBuscador);
		contentPanel.add(tbClientes);

		tfNombre = new TextField();
		tfNombre.setLabelText("Nombre");
		tfNombre.setBounds(10, 76, 183, 54);
		contentPanel.add(tfNombre);

		tfApellido = new TextField();
		tfApellido.setLabelText("Apellido");
		tfApellido.setBounds(203, 76, 235, 54);
		contentPanel.add(tfApellido);

		cbxSexo = new Combobox();
		cbxSexo.addItem("SELECCIONAR...");
		cbxSexo.addItem("MASCULINO");
		cbxSexo.addItem("FEMENINO");
		cbxSexo.setLabeText("Sexo");
		cbxSexo.setBounds(10, 141, 183, 54);
		contentPanel.add(cbxSexo);

		tfTelefono = new TextField();
		tfTelefono.setLabelText("Teléfono");
		tfTelefono.setBounds(203, 141, 235, 54);
		contentPanel.add(tfTelefono);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 428, 137);
		contentPanel.add(scrollPane);

		tfDireccion = new TextArea();
		scrollPane.setViewportView(tfDireccion);
		tfDireccion.setLabelText("Dirección");

		tfFechaNacimiento = new TextFieldFormat();
		tfFechaNacimiento.setLabelText("Fecha de nacimiento");
		tfFechaNacimiento.setBounds(10, 354, 211, 54);
		contentPanel.add(tfFechaNacimiento);

		rdbtnActivo = new JRadioButton("Activo");
		rdbtnActivo.setBounds(227, 354, 211, 23);
		contentPanel.add(rdbtnActivo);

		rdbtnInactivo = new JRadioButton("Inactivo");
		rdbtnInactivo.setBounds(227, 385, 211, 23);
		contentPanel.add(rdbtnInactivo);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirListado();
			}
		});
		btnImprimir.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/impresora.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnImprimir.setBounds(870, 11, 128, 54);
		contentPanel.add(btnImprimir);

		estadoFormulario(false);
	}

	private void imprimirListado() {
		FormFiltroListadoClientes fil = new FormFiltroListadoClientes();
		fil.setLocationRelativeTo(null);
		fil.setModal(true);
		fil.setVisible(true);
		// System.out.println(fil.getFiltro());

		Reporte rep = new Reporte();
		ConexionBD.conectar();
		rep.setConexion(ConexionBD.conexion);
		rep.setParametro("titulo", "LISTADO DE CLIENTES");
		rep.setParametro("empresa", "EMPRESA LOREM IPSUM\nTeléfono: 0001235");// NOMBRE EMPRESA. ESTO PODRÌA VENIR DE LA BD
		rep.setParametro("sql_subreporte", fil.getFiltro());//Aquí va el sql del listado
		rep.setParametro("subreporte", "listado_clientes");// este es el subreporte
		rep.setParametro("rango", fil.getRango());
		rep.setParametro("ordenamiento", fil.getOrdenamiento());
		System.out.println(fil.getFiltro());
		rep.imprimir("reporte_maestro");// este es el reporte maestro
	}

	private boolean validar() {

		if (tfCedula.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Cédula es obligatorio", "Información incompleta",
					JOptionPane.WARNING_MESSAGE);
			tfCedula.requestFocus();
			return false;
		}
		if (tfNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Nombre es obligatorio", "Información incompleta",
					JOptionPane.WARNING_MESSAGE);
			tfNombre.requestFocus();
			return false;
		}
		if (tfApellido.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Apellido es obligatorio", "Información incompleta",
					JOptionPane.WARNING_MESSAGE);
			tfApellido.requestFocus();
			return false;
		}
		if (cbxSexo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Seleccione el sexo", "Información incompleta",
					JOptionPane.WARNING_MESSAGE);
			tfApellido.requestFocus();
			return false;
		}

		if (tfFechaNacimiento.getText().contains("_")) {
			JOptionPane.showMessageDialog(null, "El campo fecha de nacimiento es obligatorio", "Información incompleta",
					JOptionPane.WARNING_MESSAGE);
			tfFechaNacimiento.requestFocus();
			tfFechaNacimiento.setText(tfFechaNacimiento.DateAString(new Date()));
			tfFechaNacimiento.selectAll();
			return false;
		}

		return true;
	}

	private void cargarFormulario() {
		if (tbClientes.getTable().getSelectedRow() > -1) {
			Clientes cli = listaClientes.get(tbClientes.getTable().getSelectedRow());
			tfID.setText(String.valueOf(cli.getId()));
			tfCedula.setText(cli.getCedula());
			tfNombre.setText(cli.getNombre());
			tfApellido.setText(cli.getApellido());
			tfTelefono.setText(cli.getTelefono());
			tfDireccion.setText(cli.getDireccion());
			tfFechaNacimiento.setText(tfFechaNacimiento.DateAString(cli.getNacimiento()));
			cbxSexo.setSelectedIndex(cli.getSexo());
			if (cli.isEstado()) {
				rdbtnActivo.setSelected(true);
				rdbtnInactivo.setSelected(false);
			} else {
				rdbtnActivo.setSelected(false);
				rdbtnInactivo.setSelected(true);
			}
		}
	}

	private void consultar() {
		listaClientes = DAOClientes.consultar(tfBuscador.getText());
		tbClientes.limpiar();
		for (Clientes clientes : listaClientes) {
			// ID", "CÉDULA", "NOMBRE Y APELLIDO", "SEXO", "TELÉFONO", "NACIMIENTO"
			// PARA SEXO 0:SELECCION 1: MASCULINO 2:FEMENINO
			String[] sexo = { "seleccion", "MASCULINO", "FEMENINO" };
			Object[] valores = { clientes.getId(), clientes.getCedula(),
					clientes.getNombre() + " " + clientes.getApellido(), sexo[clientes.getSexo()],
					clientes.getTelefono(), tfFechaNacimiento.DateAString(clientes.getNacimiento()) };
			tbClientes.setFila(valores);
		}
	}

	private void guardar() {
		Clientes cli = new Clientes();

		if (!tfID.getText().isEmpty()) {
			cli.setId(Integer.parseInt(tfID.getText()));
		}
		cli.setCedula(tfCedula.getText());
		cli.setNombre(tfNombre.getText());
		cli.setApellido(tfApellido.getText());
		cli.setDireccion(tfDireccion.getText());
		cli.setSexo(cbxSexo.getSelectedIndex());
		cli.setTelefono(tfTelefono.getText());
		cli.setNacimiento(tfFechaNacimiento.StringADate(tfFechaNacimiento.getText()));
		cli.setEstado(rdbtnActivo.isSelected());

		if (validar()) {
			if (tfID.getText().isEmpty()) {
				DAOClientes.insertar(cli);
				btnCancelar.doClick();
			} else {
				DAOClientes.actualizar(cli);
				btnCancelar.doClick();
			}
		}
	}

	private void estadoFormulario(boolean e) {
		tfCedula.setEnabled(e);
		tfNombre.setEnabled(e);
		tfApellido.setEnabled(e);
		tfTelefono.setEnabled(e);
		tfDireccion.setEnabled(e);
		tfFechaNacimiento.setEnabled(e);
		cbxSexo.setEnabled(e);
		rdbtnActivo.setEnabled(e);
		rdbtnInactivo.setEnabled(e);

		btnGuardar.setEnabled(e);
		btnCancelar.setEnabled(e);

		if (e) {
			tbClientes.setEnabled(false);
			btnNuevo.setEnabled(false);
		} else {
			tbClientes.setEnabled(true);
			btnNuevo.setEnabled(true);

			tfCedula.setText("");
			tfNombre.setText("");
			tfApellido.setText("");
			tfFechaNacimiento.setText("");
			tfDireccion.setText("");
			tfTelefono.setText("");
			cbxSexo.setSelectedIndex(0);
			consultar();
		}

	}

	AbstractAction accionEliminar = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tbClientes.getTable().getSelectedRow() > -1) {
				if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este registro de clientes?",
						"Pregunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					DAOClientes.eliminar(listaClientes.get(tbClientes.getTable().getSelectedRow()));
					consultar();
				}
			}
		}
	};

	@SuppressWarnings("serial")
	AbstractAction accionEditar = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			cargarFormulario();
			estadoFormulario(true);
		}
	};
	private JButton btnImprimir;

}
