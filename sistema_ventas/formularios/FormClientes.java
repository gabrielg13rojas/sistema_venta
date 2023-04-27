package formularios;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
import javax.swing.JRadioButton;

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
		tfID.setLabelText("ID");
		tfID.setBounds(10, 11, 183, 54);
		contentPanel.add(tfID);

		tfBuscador = new TextField();
		tfBuscador.setLabelText("Buscar por cédula, nombre o apellido");
		tfBuscador.setBounds(448, 11, 550, 54);
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

		estadoFormulario(false);
	}

	private void estadoFormulario(boolean e) {
		tfID.setEnabled(e);
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
		}

	}

	AbstractAction accionEliminar = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	};
	AbstractAction accionEditar = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	};

}
